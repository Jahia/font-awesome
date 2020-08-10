<a href="https://www.jahia.com/">
    <img src="https://www.jahia.com/modules/jahiacom-templates/images/jahia-3x.png" alt="Jahia logo" title="Jahia" align="right" height="60" />
</a>

Font Awesome
======================
This Jahia module provide the Font Awesome, the web’s most popular icon set and toolkit.

## Open-Source

This is an Open-Source module, you can find more details about Open-Source @ Jahia [in this repository](https://github.com/Jahia/open-source).

## How to call Font awesome assets
```html
<template:addResources type="css" resources="all.min.css"/>
```

## How to get the prefix
This version allows getting the prefix (fab|far|fas) from an icon using a function. 

First, you will need to add a Maven dependency to your module
```xml
<dependency>
  <groupId>org.jahia.modules</groupId>
  <artifactId>font-awesome</artifactId>
  <version>[6.0,6.2)</version>
  <scope>provided</scope>
</dependency>
```
Then declare the taglib and use the fa:getPrefix function

```xml
<%@ taglib prefix="fa" uri="http://font-awesome.com/taglibs" %>
${fa:getPrefix('fa-ban')}
```

This will return `fas` because the icon `ban` is located in the solid font (fas).

Please check the ChangeLog at https://github.com/FortAwesome/Font-Awesome/blob/master/CHANGELOG.md

## Are you a Font awesome 4 user
If yes, you should seriously read the related doc on the font awesome website https://fontawesome.com/how-to-use/on-the-web/setup/upgrading-from-version-4, but you can still try to use the deprecated font-awesome.css file or simply add ad a v4-shims.min.css to keep compatibility.
```html
<template:addResources type="css" resources="all.min.css"/>
<template:addResources type="css" resources="v4-shims.min.css"/>
```
