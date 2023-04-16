package org.chubxu.helloworld.factory.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class FirstFactoryBean implements FactoryBean<FirstBean> {
    @Override
    public FirstBean getObject() throws Exception {
        FirstBean firstBean = new FirstBean();
        firstBean.setAttributes(10);
        return firstBean;
    }

    @Override
    public Class<?> getObjectType() {
        return FirstBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
