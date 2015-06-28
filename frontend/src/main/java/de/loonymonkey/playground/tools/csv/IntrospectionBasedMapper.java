package de.loonymonkey.playground.tools.csv;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

import com.opencsv.CSVReader;
import com.opencsv.bean.MappingStrategy;

public class IntrospectionBasedMapper<T> implements MappingStrategy<T> {
    private final BeanWrapperImpl          beanWrapper;
    private final List<PropertyDescriptor> propertyDescriptors;

    public IntrospectionBasedMapper(final Class<T> clazz) {
        this.beanWrapper = new BeanWrapperImpl(clazz);
        this.propertyDescriptors = findPropertyDescriptors();
    }

    @Override
    public PropertyDescriptor findDescriptor(final int col) throws IntrospectionException {
        if (col >= 0 && col < this.propertyDescriptors.size()) {
            return this.propertyDescriptors.get(col);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T createBean() throws InstantiationException, IllegalAccessException {
        return (T) BeanUtils.instantiateClass(this.beanWrapper.getWrappedClass());
    }

    @Override
    public void captureHeader(final CSVReader reader) throws IOException {
        // not implemented - this is for writing, not for reading
    }

    @Override
    public Integer getColumnIndex(final String name) {
        Objects.requireNonNull(name);
        int i = 0;
        for (final PropertyDescriptor desc : this.propertyDescriptors) {
            if (desc.getName().equals(name)) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    private List<PropertyDescriptor> findPropertyDescriptors() {
        return Arrays.asList(this.beanWrapper.getPropertyDescriptors()).stream().filter(desc -> !desc.getName().equals("class"))
                .collect(Collectors.toList());
    }
}
