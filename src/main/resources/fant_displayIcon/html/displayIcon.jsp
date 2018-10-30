<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="template" uri="http://www.jahia.org/tags/templateLib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fa" uri="http://font-awesome.com/taglibs" %>
<%--@elvariable id="currentNode" type="org.jahia.services.content.JCRNodeWrapper"--%>

<template:addResources type="css" resources="all.min.css"/>
<template:addResources type="css" resources="v4-shims.min.css"/>

<c:set var="faIcon" value="${currentNode.properties.faIcon.string}"/>
<c:set var="faLarger" value="${currentNode.properties.faLarger.string}"/>
<c:set var="faFixedWidth" value="${currentNode.properties.faFixedWidth.boolean}"/>
<c:set var="faAnimated" value="${currentNode.properties.faAnimated.string}"/>
<c:set var="faRotatedFlipped" value="${currentNode.properties.faRotatedFlipped.string}"/>
<c:set var="fafaPulled" value="${currentNode.properties.fafaPulled.string}"/>
<c:set var="faBorder" value="${currentNode.properties.faBorder.boolean}"/>
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
<c:if test="${fafaPulled ne 'default'}">
    <c:set var="fafaPulledStr" value=" ${fafaPulled}"/>
</c:if>
<c:if test="${faBorder == true}">
    <c:set var="faBorderStr" value=" fa-border"/>
</c:if>
<i class="${fa:getPrefix(faIcon)}${' '}${faIcon}${faLargerStr}${faFixedWidthStr}${faAnimatedStr}${faRotatedFlippedStr}${fafaPulledStr}${faBorderStr}"></i>
