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

package com.liferay.commerce.channel.web.internal.portlet;

import com.liferay.commerce.channel.web.internal.display.context.CommerceChannelDisplayContext;
import com.liferay.commerce.product.catalog.rule.CPRuleTypeRegistry;
import com.liferay.commerce.product.channel.CommerceChannelTypeJSPContributorRegistry;
import com.liferay.commerce.product.channel.CommerceChannelTypeRegistry;
import com.liferay.commerce.product.constants.CPConstants;
import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.service.CPRuleService;
import com.liferay.commerce.product.service.CommerceChannelService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alec Sloan
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.preferences-owned-by-group=false",
		"com.liferay.portlet.preferences-unique-per-layout=false",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"javax.portlet.display-name=Channels",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CPPortletKeys.COMMERCE_CHANNELS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = {CommerceChannelsPortlet.class, Portlet.class}
)
public class CommerceChannelsPortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		try {
			HttpServletRequest httpServletRequest =
				_portal.getHttpServletRequest(renderRequest);

			CommerceChannelDisplayContext commerceChannelDisplayContext =
				new CommerceChannelDisplayContext(
					_commerceChannelService, _commerceChannelTypeRegistry,
					_commerceChannelTypeJSPContributorRegistry, _cpRuleService,
					_cpRuleTypeRegistry, httpServletRequest, _portal,
					_portletResourcePermission);

			renderRequest.setAttribute(
				WebKeys.PORTLET_DISPLAY_CONTEXT, commerceChannelDisplayContext);
		}
		catch (PortalException pe) {
			SessionErrors.add(renderRequest, pe.getClass());
		}

		super.render(renderRequest, renderResponse);
	}

	@Reference
	private CommerceChannelService _commerceChannelService;

	@Reference
	private CommerceChannelTypeJSPContributorRegistry
		_commerceChannelTypeJSPContributorRegistry;

	@Reference
	private CommerceChannelTypeRegistry _commerceChannelTypeRegistry;

	@Reference
	private CPRuleService _cpRuleService;

	@Reference
	private CPRuleTypeRegistry _cpRuleTypeRegistry;

	@Reference
	private Portal _portal;

	@Reference(target = "(resource.name=" + CPConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

}