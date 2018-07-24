<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="template" uri="http://www.jahia.org/tags/templateLib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="currentNode" type="org.jahia.services.content.JCRNodeWrapper"--%>

<template:addResources type="javascript" resources="v4-shims.min.js"/>
<template:addResources type="javascript" resources="all.min.js"/>

<c:set var="faIcon" value="${currentNode.properties.faIcon.string}"/>
<c:set var="faLarger" value="${currentNode.properties.faLarger.string}"/>
<c:set var="faFixedWidth" value="${currentNode.properties.faFixedWidth.boolean}"/>
<c:set var="faAnimated" value="${currentNode.properties.faAnimated.string}"/>
<c:set var="faRotatedFlipped" value="${currentNode.properties.faRotatedFlipped.string}"/>

<c:if test="${faLarger ne 'default'}">
    <c:set var="faLargerStr" value=" ${faLarger}"/>
</c:if>
<c:if test="${faFixedWidth == true}">
    <c:set var="faFixedWidthStr" value=" fa-fw"/>
</c:if>
<c:if test="${faAnimated ne 'default'}">
    <c:set var="faAnimatedStr" value=" ${faAnimated}"/>
</c:if>
<c:if test="${faRotatedFlipped ne 'default'}">
    <c:set var="faRotatedFlippedStr" value=" ${faRotatedFlipped}"/>
</c:if>
<i class="fa ${faIcon}${faLargerStr}${faFixedWidthStr}${faAnimatedStr}${faRotatedFlippedStr}"></i>
