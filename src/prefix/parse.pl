#!/usr/bin/perl
use strict;
use warnings;
use JSON::XS;

# This is an ugly perl script to generate a java map based on the icons.json to be able to recover the
# prefix (fab|fas|far) of a FA icon.
# the JSON file is https://github.com/FortAwesome/Font-Awesome/blob/master/advanced-options/metadata/icons.json
# The javafile with the HashMap is com.jahia.module.fontawesome.Prefix (in this module)

my $file = "icons.json";
my $data = do {
    local $/ = undef;
    open my $fh, "<", $file
        or die "could not open $file: $!";
    <$fh>;
};

print <<EOH;
package com.jahia.module.fontawesome;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Prefix {
    private static final Map<String, String> FA_PREFIX = createMap();

    private static Map<String, String> createMap() {
        Map<String, String> result = new HashMap<String, String>();
EOH

my $hashref = decode_json $data;

foreach my $object_name (sort keys %$hashref){
    my $prefix = "fas";
    my $style = $hashref->{$object_name}->{styles}[0];
    if ($style eq 'brands') {
        $prefix = "fab";
    } elsif ($style eq 'regular') {
        $prefix = "far";
    }
    print "        result.put(\"fa-" . $object_name . "\", \"" . $prefix . "\");\n";
}


print <<EOF;
        return Collections.unmodifiableMap(result);
    }

     public static String getPrefix(String icon) {
        String prefix = "fa";
        if (icon != null) {
            prefix = FA_PREFIX.get(icon);
        }
        if (prefix.length() == 0) {
            prefix = "fa";
        }
        return prefix;
    }
}
EOF
