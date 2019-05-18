/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.product.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CPRule service. Represents a row in the &quot;CPRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.product.model.impl.CPRuleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.product.model.impl.CPRuleImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPRule
 * @see com.liferay.commerce.product.model.impl.CPRuleImpl
 * @see com.liferay.commerce.product.model.impl.CPRuleModelImpl
 * @generated
 */
@ProviderType
public interface CPRuleModel extends AttachedModel, BaseModel<CPRule>,
	GroupedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cp rule model instance should use the {@link CPRule} interface instead.
	 */

	/**
	 * Returns the primary key of this cp rule.
	 *
	 * @return the primary key of this cp rule
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cp rule.
	 *
	 * @param primaryKey the primary key of this cp rule
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cp rule ID of this cp rule.
	 *
	 * @return the cp rule ID of this cp rule
	 */
	public long getCPRuleId();

	/**
	 * Sets the cp rule ID of this cp rule.
	 *
	 * @param CPRuleId the cp rule ID of this cp rule
	 */
	public void setCPRuleId(long CPRuleId);

	/**
	 * Returns the group ID of this cp rule.
	 *
	 * @return the group ID of this cp rule
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this cp rule.
	 *
	 * @param groupId the group ID of this cp rule
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this cp rule.
	 *
	 * @return the company ID of this cp rule
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this cp rule.
	 *
	 * @param companyId the company ID of this cp rule
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this cp rule.
	 *
	 * @return the user ID of this cp rule
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this cp rule.
	 *
	 * @param userId the user ID of this cp rule
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this cp rule.
	 *
	 * @return the user uuid of this cp rule
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this cp rule.
	 *
	 * @param userUuid the user uuid of this cp rule
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this cp rule.
	 *
	 * @return the user name of this cp rule
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this cp rule.
	 *
	 * @param userName the user name of this cp rule
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this cp rule.
	 *
	 * @return the create date of this cp rule
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this cp rule.
	 *
	 * @param createDate the create date of this cp rule
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this cp rule.
	 *
	 * @return the modified date of this cp rule
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this cp rule.
	 *
	 * @param modifiedDate the modified date of this cp rule
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this cp rule.
	 *
	 * @return the fully qualified class name of this cp rule
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this cp rule.
	 *
	 * @return the class name ID of this cp rule
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this cp rule.
	 *
	 * @param classNameId the class name ID of this cp rule
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class pk of this cp rule.
	 *
	 * @return the class pk of this cp rule
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class pk of this cp rule.
	 *
	 * @param classPK the class pk of this cp rule
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the name of this cp rule.
	 *
	 * @return the name of this cp rule
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this cp rule.
	 *
	 * @param name the name of this cp rule
	 */
	public void setName(String name);

	/**
	 * Returns the active of this cp rule.
	 *
	 * @return the active of this cp rule
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this cp rule is active.
	 *
	 * @return <code>true</code> if this cp rule is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this cp rule is active.
	 *
	 * @param active the active of this cp rule
	 */
	public void setActive(boolean active);

	/**
	 * Returns the type of this cp rule.
	 *
	 * @return the type of this cp rule
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this cp rule.
	 *
	 * @param type the type of this cp rule
	 */
	public void setType(String type);

	/**
	 * Returns the type settings of this cp rule.
	 *
	 * @return the type settings of this cp rule
	 */
	@AutoEscape
	public String getTypeSettings();

	/**
	 * Sets the type settings of this cp rule.
	 *
	 * @param typeSettings the type settings of this cp rule
	 */
	public void setTypeSettings(String typeSettings);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CPRule cpRule);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CPRule> toCacheModel();

	@Override
	public CPRule toEscapedModel();

	@Override
	public CPRule toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}