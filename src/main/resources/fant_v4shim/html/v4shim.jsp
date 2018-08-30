<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="template" uri="http://www.jahia.org/tags/templateLib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="currentNode" type="org.jahia.services.content.JCRNodeWrapper"--%>

<template:addResources type="css" resources="all.min.css"/>
<template:addResources type="css" resources="v4-shims.css"/>

<c:if test="${renderContext.editMode}">
    This component will allow you to keep your old version 4 icon names, aliases, and syntax.
</c:if>
