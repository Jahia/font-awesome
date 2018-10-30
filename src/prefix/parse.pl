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

my $hashref = decode_json $data;

foreach my $object_name (sort keys %$hashref){
    my $prefix = "fas";
    my $style = $hashref->{$object_name}->{styles}[-1];
    if ($style eq 'brands') {
        $prefix = "fab";
    } elsif ($style eq 'regular') {
        $prefix = "far";
    }
    print "result.put(\"fa-" . $object_name . "\", \"" . $prefix . "\");\n";
}



#class en static final
