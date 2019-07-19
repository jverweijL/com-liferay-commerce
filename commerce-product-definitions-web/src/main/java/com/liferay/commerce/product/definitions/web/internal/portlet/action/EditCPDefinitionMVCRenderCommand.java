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

package com.liferay.commerce.product.definitions.web.internal.portlet.action;

import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.constants.CPWebKeys;
import com.liferay.commerce.product.definitions.portlet.action.ActionHelper;
import com.liferay.commerce.product.definitions.web.internal.display.context.CPDefinitionsDisplayContext;
import com.liferay.commerce.product.exception.NoSuchCPDefinitionException;
import com.liferay.commerce.product.service.CPDefinitionService;
import com.liferay.commerce.product.service.CommerceCatalogService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 * @author Marco Leo
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CPPortletKeys.CP_DEFINITIONS,
		"mvc.command.name=editProductDefinition"
	},
	service = MVCRenderCommand.class
)
public class EditCPDefinitionMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		try {
			CPDefinitionsDisplayContext cpDefinitionsDisplayContext =
				new CPDefinitionsDisplayContext(
					_actionHelper, _portal.getHttpServletRequest(renderRequest),
					_commerceCatalogService, _cpDefinitionService);

			renderRequest.setAttribute(
				WebKeys.PORTLET_DISPLAY_CONTEXT, cpDefinitionsDisplayContext);

			setCPDefinitionRequestAttribute(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchCPDefinitionException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass());

				return "/error.jsp";
			}

			throw new PortletException(e);
		}

		return "/edit_definition.jsp";
	}

	protected void setCPDefinitionRequestAttribute(RenderRequest renderRequest)
		throws PortalException {

		renderRequest.setAttribute(
			CPWebKeys.CP_DEFINITION,
			_actionHelper.getCPDefinition(renderRequest));
	}

	@Reference
	private ActionHelper _actionHelper;

	@Reference
	private CommerceCatalogService _commerceCatalogService;

	@Reference
	private CPDefinitionService _cpDefinitionService;

	@Reference
	private Portal _portal;

}