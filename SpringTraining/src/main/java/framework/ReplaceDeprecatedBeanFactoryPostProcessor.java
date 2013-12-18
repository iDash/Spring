package framework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

public class ReplaceDeprecatedBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            AbstractBeanDefinition beanDefinition =
                    (AbstractBeanDefinition) beanFactory.getBeanDefinition(beanName);
            String originalClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(originalClassName);
                MyDeprecated annotation = originalClass.getAnnotation(MyDeprecated.class);

                if (annotation != null) {
                    Class newClass = annotation.newClass();
                    beanDefinition.setBeanClassName(newClass.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
