<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="template" uri="http://www.jahia.org/tags/templateLib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="currentNode" type="org.jahia.services.content.JCRNodeWrapper"--%>

<template:addResources type="javascript" resources="v4-shims.js"/>
<template:addResources type="javascript" resources="all.js"/>

<c:if test="${renderContext.editMode}">
    This component will allow you to keep your old version 4 icon names, aliases, and syntax.
</c:if>
