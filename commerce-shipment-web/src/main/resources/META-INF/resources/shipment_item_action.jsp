<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
CommerceShipmentItemDisplayContext commerceShipmentItemDisplayContext = (CommerceShipmentItemDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

CommerceShipmentItem commerceShipmentItem = (CommerceShipmentItem)row.getObject();
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= commerceShipmentItemDisplayContext.hasManageCommerceShipmentsPermission() %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="mvcRenderCommandName" value="editCommerceShipmentItem" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="commerceShipmentId" value="<%= String.valueOf(commerceShipmentItem.getCommerceShipmentId()) %>" />
			<portlet:param name="commerceShipmentItemId" value="<%= String.valueOf(commerceShipmentItem.getCommerceShipmentItemId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editURL %>"
		/>

		<portlet:actionURL name="editCommerceShipmentItem" var="deleteURL">
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="commerceShipmentId" value="<%= String.valueOf(commerceShipmentItem.getCommerceShipmentId()) %>" />
			<portlet:param name="commerceShipmentItemId" value="<%= String.valueOf(commerceShipmentItem.getCommerceShipmentItemId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			label="<%= true %>"
			url="<%= deleteURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>