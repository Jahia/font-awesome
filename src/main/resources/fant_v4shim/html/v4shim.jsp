<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="template" uri="http://www.jahia.org/tags/templateLib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="currentNode" type="org.jahia.services.content.JCRNodeWrapper"--%>

<template:addResources type="javascript" resources="fa-v4-shims.min.js"/>
<template:addResources type="javascript" resources="fontawesome-all.min.js"/>

<c:if test="${renderContext.editMode}">
    This component will allow you to keep your old version 4 icon names, aliases, and syntax.
</c:if>