/**
 * ==========================================================================================
 * =                   JAHIA'S DUAL LICENSING - IMPORTANT INFORMATION                       =
 * ==========================================================================================
 *
 *                                 http://www.jahia.com
 *
 *     Copyright (C) 2002-2018 Jahia Solutions Group SA. All rights reserved.
 *
 *     THIS FILE IS AVAILABLE UNDER TWO DIFFERENT LICENSES:
 *     1/GPL OR 2/JSEL
 *
 *     1/ GPL
 *     ==================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE GPL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *     2/ JSEL - Commercial and Supported Versions of the program
 *     ===================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE JSEL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     Alternatively, commercial and supported versions of the program - also known as
 *     Enterprise Distributions - must be used in accordance with the terms and conditions
 *     contained in a separate written agreement between you and Jahia Solutions Group SA.
 *
 *     If you are unsure which license is appropriate for your use,
 *     please contact the sales department at sales@jahia.com.
 */
package com.jahia.initializers;

import org.jahia.services.content.JCRPropertyWrapper;
import org.jahia.services.content.nodetypes.ExtendedPropertyDefinition;
import org.jahia.services.content.nodetypes.initializers.ChoiceListValue;
import org.jahia.services.content.nodetypes.initializers.ModuleChoiceListInitializer;
import org.jahia.services.content.nodetypes.renderer.AbstractChoiceListRenderer;
import org.jahia.services.content.nodetypes.renderer.ModuleChoiceListRenderer;
import org.jahia.services.render.RenderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class IconInitializer extends AbstractChoiceListRenderer implements ModuleChoiceListInitializer, ModuleChoiceListRenderer {

    private static final Logger logger = LoggerFactory.getLogger(IconInitializer.class);

    private String key;

    /**
     * {@inheritDoc}
     */
    protected static final String[] ICONS = {
            "fa-500px",
            "fa-accessible-icon",
            "fa-accusoft",
            "fa-address-book",
            "fa-address-card",
            "fa-adjust",
            "fa-adn",
            "fa-adversal",
            "fa-affiliatetheme",
            "fa-algolia",
            "fa-align-center",
            "fa-align-justify",
            "fa-align-left",
            "fa-align-right",
            "fa-allergies",
            "fa-amazon-pay",
            "fa-amazon",
            "fa-ambulance",
            "fa-american-sign-language-interpreting",
            "fa-amilia",
            "fa-anchor",
            "fa-android",
            "fa-angellist",
            "fa-angle-double-down",
            "fa-angle-double-left",
            "fa-angle-double-right",
            "fa-angle-double-up",
            "fa-angle-down",
            "fa-angle-left",
            "fa-angle-right",
            "fa-angle-up",
            "fa-angry",
            "fa-angrycreative",
            "fa-angular",
            "fa-app-store-ios",
            "fa-app-store",
            "fa-apper",
            "fa-apple-pay",
            "fa-apple",
            "fa-archive",
            "fa-archway",
            "fa-arrow-alt-circle-down",
            "fa-arrow-alt-circle-left",
            "fa-arrow-alt-circle-right",
            "fa-arrow-alt-circle-up",
            "fa-arrow-circle-down",
            "fa-arrow-circle-left",
            "fa-arrow-circle-right",
            "fa-arrow-circle-up",
            "fa-arrow-down",
            "fa-arrow-left",
            "fa-arrow-right",
            "fa-arrow-up",
            "fa-arrows-alt-h",
            "fa-arrows-alt-v",
            "fa-arrows-alt",
            "fa-assistive-listening-systems",
            "fa-asterisk",
            "fa-asymmetrik",
            "fa-at",
            "fa-atlas",
            "fa-audible",
            "fa-audio-description",
            "fa-autoprefixer",
            "fa-avianex",
            "fa-aviato",
            "fa-award",
            "fa-aws",
            "fa-backspace",
            "fa-backward",
            "fa-balance-scale",
            "fa-ban",
            "fa-band-aid",
            "fa-bandcamp",
            "fa-barcode",
            "fa-bars",
            "fa-baseball-ball",
            "fa-basketball-ball",
            "fa-bath",
            "fa-battery-empty",
            "fa-battery-full",
            "fa-battery-half",
            "fa-battery-quarter",
            "fa-battery-three-quarters",
            "fa-bed",
            "fa-beer",
            "fa-behance-square",
            "fa-behance",
            "fa-bell-slash",
            "fa-bell",
            "fa-bezier-curve",
            "fa-bicycle",
            "fa-bimobject",
            "fa-binoculars",
            "fa-birthday-cake",
            "fa-bitbucket",
            "fa-bitcoin",
            "fa-bity",
            "fa-black-tie",
            "fa-blackberry",
            "fa-blender",
            "fa-blind",
            "fa-blogger-b",
            "fa-blogger",
            "fa-bluetooth-b",
            "fa-bluetooth",
            "fa-bold",
            "fa-bolt",
            "fa-bomb",
            "fa-bong",
            "fa-book-open",
            "fa-book",
            "fa-bookmark",
            "fa-bowling-ball",
            "fa-box-open",
            "fa-box",
            "fa-boxes",
            "fa-braille",
            "fa-briefcase-medical",
            "fa-briefcase",
            "fa-broadcast-tower",
            "fa-broom",
            "fa-brush",
            "fa-btc",
            "fa-bug",
            "fa-building",
            "fa-bullhorn",
            "fa-bullseye",
            "fa-burn",
            "fa-buromobelexperte",
            "fa-bus-alt",
            "fa-bus",
            "fa-buysellads",
            "fa-calculator",
            "fa-calendar-alt",
            "fa-calendar-check",
            "fa-calendar-minus",
            "fa-calendar-plus",
            "fa-calendar-times",
            "fa-calendar",
            "fa-camera-retro",
            "fa-camera",
            "fa-cannabis",
            "fa-capsules",
            "fa-car",
            "fa-caret-down",
            "fa-caret-left",
            "fa-caret-right",
            "fa-caret-square-down",
            "fa-caret-square-left",
            "fa-caret-square-right",
            "fa-caret-square-up",
            "fa-caret-up",
            "fa-cart-arrow-down",
            "fa-cart-plus",
            "fa-cc-amazon-pay",
            "fa-cc-amex",
            "fa-cc-apple-pay",
            "fa-cc-diners-club",
            "fa-cc-discover",
            "fa-cc-jcb",
            "fa-cc-mastercard",
            "fa-cc-paypal",
            "fa-cc-stripe",
            "fa-cc-visa",
            "fa-centercode",
            "fa-certificate",
            "fa-chalkboard-teacher",
            "fa-chalkboard",
            "fa-chart-area",
            "fa-chart-bar",
            "fa-chart-line",
            "fa-chart-pie",
            "fa-check-circle",
            "fa-check-double",
            "fa-check-square",
            "fa-check",
            "fa-chess-bishop",
            "fa-chess-board",
            "fa-chess-king",
            "fa-chess-knight",
            "fa-chess-pawn",
            "fa-chess-queen",
            "fa-chess-rook",
            "fa-chess",
            "fa-chevron-circle-down",
            "fa-chevron-circle-left",
            "fa-chevron-circle-right",
            "fa-chevron-circle-up",
            "fa-chevron-down",
            "fa-chevron-left",
            "fa-chevron-right",
            "fa-chevron-up",
            "fa-child",
            "fa-chrome",
            "fa-church",
            "fa-circle-notch",
            "fa-circle",
            "fa-clipboard-check",
            "fa-clipboard-list",
            "fa-clipboard",
            "fa-clock",
            "fa-clone",
            "fa-closed-captioning",
            "fa-cloud-download-alt",
            "fa-cloud-upload-alt",
            "fa-cloud",
            "fa-cloudscale",
            "fa-cloudsmith",
            "fa-cloudversify",
            "fa-cocktail",
            "fa-code-branch",
            "fa-code",
            "fa-codepen",
            "fa-codiepie",
            "fa-coffee",
            "fa-cog",
            "fa-cogs",
            "fa-coins",
            "fa-columns",
            "fa-comment-alt",
            "fa-comment-dots",
            "fa-comment-slash",
            "fa-comment",
            "fa-comments",
            "fa-compact-disc",
            "fa-compass",
            "fa-compress",
            "fa-concierge-bell",
            "fa-connectdevelop",
            "fa-contao",
            "fa-cookie-bite",
            "fa-cookie",
            "fa-copy",
            "fa-copyright",
            "fa-couch",
            "fa-cpanel",
            "fa-creative-commons-by",
            "fa-creative-commons-nc-eu",
            "fa-creative-commons-nc-jp",
            "fa-creative-commons-nc",
            "fa-creative-commons-nd",
            "fa-creative-commons-pd-alt",
            "fa-creative-commons-pd",
            "fa-creative-commons-remix",
            "fa-creative-commons-sa",
            "fa-creative-commons-sampling-plus",
            "fa-creative-commons-sampling",
            "fa-creative-commons-share",
            "fa-creative-commons",
            "fa-credit-card",
            "fa-crop-alt",
            "fa-crop",
            "fa-crosshairs",
            "fa-crow",
            "fa-crown",
            "fa-css3-alt",
            "fa-css3",
            "fa-cube",
            "fa-cubes",
            "fa-cut",
            "fa-cuttlefish",
            "fa-d-and-d",
            "fa-dashcube",
            "fa-database",
            "fa-deaf",
            "fa-delicious",
            "fa-deploydog",
            "fa-deskpro",
            "fa-desktop",
            "fa-deviantart",
            "fa-diagnoses",
            "fa-dice-five",
            "fa-dice-four",
            "fa-dice-one",
            "fa-dice-six",
            "fa-dice-three",
            "fa-dice-two",
            "fa-dice",
            "fa-digg",
            "fa-digital-ocean",
            "fa-digital-tachograph",
            "fa-discord",
            "fa-discourse",
            "fa-divide",
            "fa-dizzy",
            "fa-dna",
            "fa-dochub",
            "fa-docker",
            "fa-dollar-sign",
            "fa-dolly-flatbed",
            "fa-dolly",
            "fa-donate",
            "fa-door-closed",
            "fa-door-open",
            "fa-dot-circle",
            "fa-dove",
            "fa-download",
            "fa-draft2digital",
            "fa-drafting-compass",
            "fa-dribbble-square",
            "fa-dribbble",
            "fa-dropbox",
            "fa-drum-steelpan",
            "fa-drum",
            "fa-drupal",
            "fa-dumbbell",
            "fa-dyalog",
            "fa-earlybirds",
            "fa-ebay",
            "fa-edge",
            "fa-edit",
            "fa-eject",
            "fa-elementor",
            "fa-ellipsis-h",
            "fa-ellipsis-v",
            "fa-ember",
            "fa-empire",
            "fa-envelope-open",
            "fa-envelope-square",
            "fa-envelope",
            "fa-envira",
            "fa-equals",
            "fa-eraser",
            "fa-erlang",
            "fa-ethereum",
            "fa-etsy",
            "fa-euro-sign",
            "fa-exchange-alt",
            "fa-exclamation-circle",
            "fa-exclamation-triangle",
            "fa-exclamation",
            "fa-expand-arrows-alt",
            "fa-expand",
            "fa-expeditedssl",
            "fa-external-link-alt",
            "fa-external-link-square-alt",
            "fa-eye-dropper",
            "fa-eye-slash",
            "fa-eye",
            "fa-facebook-f",
            "fa-facebook-messenger",
            "fa-facebook-square",
            "fa-facebook",
            "fa-fast-backward",
            "fa-fast-forward",
            "fa-fax",
            "fa-feather-alt",
            "fa-feather",
            "fa-female",
            "fa-fighter-jet",
            "fa-file-alt",
            "fa-file-archive",
            "fa-file-audio",
            "fa-file-code",
            "fa-file-contract",
            "fa-file-download",
            "fa-file-excel",
            "fa-file-export",
            "fa-file-image",
            "fa-file-import",
            "fa-file-invoice-dollar",
            "fa-file-invoice",
            "fa-file-medical-alt",
            "fa-file-medical",
            "fa-file-pdf",
            "fa-file-powerpoint",
            "fa-file-prescription",
            "fa-file-signature",
            "fa-file-upload",
            "fa-file-video",
            "fa-file-word",
            "fa-file",
            "fa-fill-drip",
            "fa-fill",
            "fa-film",
            "fa-filter",
            "fa-fingerprint",
            "fa-fire-extinguisher",
            "fa-fire",
            "fa-firefox",
            "fa-first-aid",
            "fa-first-order-alt",
            "fa-first-order",
            "fa-firstdraft",
            "fa-fish",
            "fa-flag-checkered",
            "fa-flag",
            "fa-flask",
            "fa-flickr",
            "fa-flipboard",
            "fa-flushed",
            "fa-fly",
            "fa-folder-open",
            "fa-folder",
            "fa-font-awesome-alt",
            "fa-font-awesome-flag",
            "fa-font-awesome-logo-full",
            "fa-font-awesome",
            "fa-font",
            "fa-fonticons-fi",
            "fa-fonticons",
            "fa-football-ball",
            "fa-fort-awesome-alt",
            "fa-fort-awesome",
            "fa-forumbee",
            "fa-forward",
            "fa-foursquare",
            "fa-free-code-camp",
            "fa-freebsd",
            "fa-frog",
            "fa-frown-open",
            "fa-frown",
            "fa-fulcrum",
            "fa-futbol",
            "fa-galactic-republic",
            "fa-galactic-senate",
            "fa-gamepad",
            "fa-gas-pump",
            "fa-gavel",
            "fa-gem",
            "fa-genderless",
            "fa-get-pocket",
            "fa-gg-circle",
            "fa-gg",
            "fa-gift",
            "fa-git-square",
            "fa-git",
            "fa-github-alt",
            "fa-github-square",
            "fa-github",
            "fa-gitkraken",
            "fa-gitlab",
            "fa-gitter",
            "fa-glass-martini-alt",
            "fa-glass-martini",
            "fa-glasses",
            "fa-glide-g",
            "fa-glide",
            "fa-globe-africa",
            "fa-globe-americas",
            "fa-globe-asia",
            "fa-globe",
            "fa-gofore",
            "fa-golf-ball",
            "fa-goodreads-g",
            "fa-goodreads",
            "fa-google-drive",
            "fa-google-play",
            "fa-google-plus-g",
            "fa-google-plus-square",
            "fa-google-plus",
            "fa-google-wallet",
            "fa-google",
            "fa-graduation-cap",
            "fa-gratipay",
            "fa-grav",
            "fa-greater-than-equal",
            "fa-greater-than",
            "fa-grimace",
            "fa-grin-alt",
            "fa-grin-beam-sweat",
            "fa-grin-beam",
            "fa-grin-hearts",
            "fa-grin-squint-tears",
            "fa-grin-squint",
            "fa-grin-stars",
            "fa-grin-tears",
            "fa-grin-tongue-squint",
            "fa-grin-tongue-wink",
            "fa-grin-tongue",
            "fa-grin-wink",
            "fa-grin",
            "fa-grip-horizontal",
            "fa-grip-vertical",
            "fa-gripfire",
            "fa-grunt",
            "fa-gulp",
            "fa-h-square",
            "fa-hacker-news-square",
            "fa-hacker-news",
            "fa-hand-holding-heart",
            "fa-hand-holding-usd",
            "fa-hand-holding",
            "fa-hand-lizard",
            "fa-hand-paper",
            "fa-hand-peace",
            "fa-hand-point-down",
            "fa-hand-point-left",
            "fa-hand-point-right",
            "fa-hand-point-up",
            "fa-hand-pointer",
            "fa-hand-rock",
            "fa-hand-scissors",
            "fa-hand-spock",
            "fa-hands-helping",
            "fa-hands",
            "fa-handshake",
            "fa-hashtag",
            "fa-hdd",
            "fa-heading",
            "fa-headphones-alt",
            "fa-headphones",
            "fa-headset",
            "fa-heart",
            "fa-heartbeat",
            "fa-helicopter",
            "fa-highlighter",
            "fa-hips",
            "fa-hire-a-helper",
            "fa-history",
            "fa-hockey-puck",
            "fa-home",
            "fa-hooli",
            "fa-hornbill",
            "fa-hospital-alt",
            "fa-hospital-symbol",
            "fa-hospital",
            "fa-hot-tub",
            "fa-hotel",
            "fa-hotjar",
            "fa-hourglass-end",
            "fa-hourglass-half",
            "fa-hourglass-start",
            "fa-hourglass",
            "fa-houzz",
            "fa-html5",
            "fa-hubspot",
            "fa-i-cursor",
            "fa-id-badge",
            "fa-id-card-alt",
            "fa-id-card",
            "fa-image",
            "fa-images",
            "fa-imdb",
            "fa-inbox",
            "fa-indent",
            "fa-industry",
            "fa-infinity",
            "fa-info-circle",
            "fa-info",
            "fa-instagram",
            "fa-internet-explorer",
            "fa-ioxhost",
            "fa-italic",
            "fa-itunes-note",
            "fa-itunes",
            "fa-java",
            "fa-jedi-order",
            "fa-jenkins",
            "fa-joget",
            "fa-joint",
            "fa-joomla",
            "fa-js-square",
            "fa-js",
            "fa-jsfiddle",
            "fa-key",
            "fa-keybase",
            "fa-keyboard",
            "fa-keycdn",
            "fa-kickstarter-k",
            "fa-kickstarter",
            "fa-kiss-beam",
            "fa-kiss-wink-heart",
            "fa-kiss",
            "fa-kiwi-bird",
            "fa-korvue",
            "fa-language",
            "fa-laptop",
            "fa-laravel",
            "fa-lastfm-square",
            "fa-lastfm",
            "fa-laugh-beam",
            "fa-laugh-squint",
            "fa-laugh-wink",
            "fa-laugh",
            "fa-leaf",
            "fa-leanpub",
            "fa-lemon",
            "fa-less-than-equal",
            "fa-less-than",
            "fa-less",
            "fa-level-down-alt",
            "fa-level-up-alt",
            "fa-life-ring",
            "fa-lightbulb",
            "fa-line",
            "fa-link",
            "fa-linkedin-in",
            "fa-linkedin",
            "fa-linode",
            "fa-linux",
            "fa-lira-sign",
            "fa-list-alt",
            "fa-list-ol",
            "fa-list-ul",
            "fa-list",
            "fa-location-arrow",
            "fa-lock-open",
            "fa-lock",
            "fa-long-arrow-alt-down",
            "fa-long-arrow-alt-left",
            "fa-long-arrow-alt-right",
            "fa-long-arrow-alt-up",
            "fa-low-vision",
            "fa-luggage-cart",
            "fa-lyft",
            "fa-magento",
            "fa-magic",
            "fa-magnet",
            "fa-mailchimp",
            "fa-male",
            "fa-mandalorian",
            "fa-map-marked-alt",
            "fa-map-marked",
            "fa-map-marker-alt",
            "fa-map-marker",
            "fa-map-pin",
            "fa-map-signs",
            "fa-map",
            "fa-marker",
            "fa-mars-double",
            "fa-mars-stroke-h",
            "fa-mars-stroke-v",
            "fa-mars-stroke",
            "fa-mars",
            "fa-mastodon",
            "fa-maxcdn",
            "fa-medal",
            "fa-medapps",
            "fa-medium-m",
            "fa-medium",
            "fa-medkit",
            "fa-medrt",
            "fa-meetup",
            "fa-megaport",
            "fa-meh-blank",
            "fa-meh-rolling-eyes",
            "fa-meh",
            "fa-memory",
            "fa-mercury",
            "fa-microchip",
            "fa-microphone-alt-slash",
            "fa-microphone-alt",
            "fa-microphone-slash",
            "fa-microphone",
            "fa-microsoft",
            "fa-minus-circle",
            "fa-minus-square",
            "fa-minus",
            "fa-mix",
            "fa-mixcloud",
            "fa-mizuni",
            "fa-mobile-alt",
            "fa-mobile",
            "fa-modx",
            "fa-monero",
            "fa-money-bill-alt",
            "fa-money-bill-wave-alt",
            "fa-money-bill-wave",
            "fa-money-bill",
            "fa-money-check-alt",
            "fa-money-check",
            "fa-monument",
            "fa-moon",
            "fa-mortar-pestle",
            "fa-motorcycle",
            "fa-mouse-pointer",
            "fa-music",
            "fa-napster",
            "fa-neuter",
            "fa-newspaper",
            "fa-nimblr",
            "fa-nintendo-switch",
            "fa-node-js",
            "fa-node",
            "fa-not-equal",
            "fa-notes-medical",
            "fa-npm",
            "fa-ns8",
            "fa-nutritionix",
            "fa-object-group",
            "fa-object-ungroup",
            "fa-odnoklassniki-square",
            "fa-odnoklassniki",
            "fa-old-republic",
            "fa-opencart",
            "fa-openid",
            "fa-opera",
            "fa-optin-monster",
            "fa-osi",
            "fa-outdent",
            "fa-page4",
            "fa-pagelines",
            "fa-paint-brush",
            "fa-paint-roller",
            "fa-palette",
            "fa-palfed",
            "fa-pallet",
            "fa-paper-plane",
            "fa-paperclip",
            "fa-parachute-box",
            "fa-paragraph",
            "fa-parking",
            "fa-passport",
            "fa-paste",
            "fa-patreon",
            "fa-pause-circle",
            "fa-pause",
            "fa-paw",
            "fa-paypal",
            "fa-pen-alt",
            "fa-pen-fancy",
            "fa-pen-nib",
            "fa-pen-square",
            "fa-pen",
            "fa-pencil-alt",
            "fa-pencil-ruler",
            "fa-people-carry",
            "fa-percent",
            "fa-percentage",
            "fa-periscope",
            "fa-phabricator",
            "fa-phoenix-framework",
            "fa-phoenix-squadron",
            "fa-phone-slash",
            "fa-phone-square",
            "fa-phone-volume",
            "fa-phone",
            "fa-php",
            "fa-pied-piper-alt",
            "fa-pied-piper-hat",
            "fa-pied-piper-pp",
            "fa-pied-piper",
            "fa-piggy-bank",
            "fa-pills",
            "fa-pinterest-p",
            "fa-pinterest-square",
            "fa-pinterest",
            "fa-plane-arrival",
            "fa-plane-departure",
            "fa-plane",
            "fa-play-circle",
            "fa-play",
            "fa-playstation",
            "fa-plug",
            "fa-plus-circle",
            "fa-plus-square",
            "fa-plus",
            "fa-podcast",
            "fa-poo",
            "fa-portrait",
            "fa-pound-sign",
            "fa-power-off",
            "fa-prescription-bottle-alt",
            "fa-prescription-bottle",
            "fa-prescription",
            "fa-print",
            "fa-procedures",
            "fa-product-hunt",
            "fa-project-diagram",
            "fa-pushed",
            "fa-puzzle-piece",
            "fa-python",
            "fa-qq",
            "fa-qrcode",
            "fa-question-circle",
            "fa-question",
            "fa-quidditch",
            "fa-quinscape",
            "fa-quora",
            "fa-quote-left",
            "fa-quote-right",
            "fa-r-project",
            "fa-random",
            "fa-ravelry",
            "fa-react",
            "fa-readme",
            "fa-rebel",
            "fa-receipt",
            "fa-recycle",
            "fa-red-river",
            "fa-reddit-alien",
            "fa-reddit-square",
            "fa-reddit",
            "fa-redo-alt",
            "fa-redo",
            "fa-registered",
            "fa-rendact",
            "fa-renren",
            "fa-reply-all",
            "fa-reply",
            "fa-replyd",
            "fa-researchgate",
            "fa-resolving",
            "fa-retweet",
            "fa-ribbon",
            "fa-road",
            "fa-robot",
            "fa-rocket",
            "fa-rocketchat",
            "fa-rockrms",
            "fa-rss-square",
            "fa-rss",
            "fa-ruble-sign",
            "fa-ruler-combined",
            "fa-ruler-horizontal",
            "fa-ruler-vertical",
            "fa-ruler",
            "fa-rupee-sign",
            "fa-sad-cry",
            "fa-sad-tear",
            "fa-safari",
            "fa-sass",
            "fa-save",
            "fa-schlix",
            "fa-school",
            "fa-screwdriver",
            "fa-scribd",
            "fa-search-minus",
            "fa-search-plus",
            "fa-search",
            "fa-searchengin",
            "fa-seedling",
            "fa-sellcast",
            "fa-sellsy",
            "fa-server",
            "fa-servicestack",
            "fa-share-alt-square",
            "fa-share-alt",
            "fa-share-square",
            "fa-share",
            "fa-shekel-sign",
            "fa-shield-alt",
            "fa-ship",
            "fa-shipping-fast",
            "fa-shirtsinbulk",
            "fa-shoe-prints",
            "fa-shopping-bag",
            "fa-shopping-basket",
            "fa-shopping-cart",
            "fa-shopware",
            "fa-shower",
            "fa-shuttle-van",
            "fa-sign-in-alt",
            "fa-sign-language",
            "fa-sign-out-alt",
            "fa-sign",
            "fa-signal",
            "fa-signature",
            "fa-simplybuilt",
            "fa-sistrix",
            "fa-sitemap",
            "fa-sith",
            "fa-skull",
            "fa-skyatlas",
            "fa-skype",
            "fa-slack-hash",
            "fa-slack",
            "fa-sliders-h",
            "fa-slideshare",
            "fa-smile-beam",
            "fa-smile-wink",
            "fa-smile",
            "fa-smoking-ban",
            "fa-smoking",
            "fa-snapchat-ghost",
            "fa-snapchat-square",
            "fa-snapchat",
            "fa-snowflake",
            "fa-solar-panel",
            "fa-sort-alpha-down",
            "fa-sort-alpha-up",
            "fa-sort-amount-down",
            "fa-sort-amount-up",
            "fa-sort-down",
            "fa-sort-numeric-down",
            "fa-sort-numeric-up",
            "fa-sort-up",
            "fa-sort",
            "fa-soundcloud",
            "fa-spa",
            "fa-space-shuttle",
            "fa-speakap",
            "fa-spinner",
            "fa-splotch",
            "fa-spotify",
            "fa-spray-can",
            "fa-square-full",
            "fa-square",
            "fa-squarespace",
            "fa-stack-exchange",
            "fa-stack-overflow",
            "fa-stamp",
            "fa-star-half-alt",
            "fa-star-half",
            "fa-star",
            "fa-staylinked",
            "fa-steam-square",
            "fa-steam-symbol",
            "fa-steam",
            "fa-step-backward",
            "fa-step-forward",
            "fa-stethoscope",
            "fa-sticker-mule",
            "fa-sticky-note",
            "fa-stop-circle",
            "fa-stop",
            "fa-stopwatch",
            "fa-store-alt",
            "fa-store",
            "fa-strava",
            "fa-stream",
            "fa-street-view",
            "fa-strikethrough",
            "fa-stripe-s",
            "fa-stripe",
            "fa-stroopwafel",
            "fa-studiovinari",
            "fa-stumbleupon-circle",
            "fa-stumbleupon",
            "fa-subscript",
            "fa-subway",
            "fa-suitcase-rolling",
            "fa-suitcase",
            "fa-sun",
            "fa-superpowers",
            "fa-superscript",
            "fa-supple",
            "fa-surprise",
            "fa-swatchbook",
            "fa-swimmer",
            "fa-swimming-pool",
            "fa-sync-alt",
            "fa-sync",
            "fa-syringe",
            "fa-table-tennis",
            "fa-table",
            "fa-tablet-alt",
            "fa-tablet",
            "fa-tablets",
            "fa-tachometer-alt",
            "fa-tag",
            "fa-tags",
            "fa-tape",
            "fa-tasks",
            "fa-taxi",
            "fa-teamspeak",
            "fa-telegram-plane",
            "fa-telegram",
            "fa-tencent-weibo",
            "fa-terminal",
            "fa-text-height",
            "fa-text-width",
            "fa-th-large",
            "fa-th-list",
            "fa-th",
            "fa-themeco",
            "fa-themeisle",
            "fa-thermometer-empty",
            "fa-thermometer-full",
            "fa-thermometer-half",
            "fa-thermometer-quarter",
            "fa-thermometer-three-quarters",
            "fa-thermometer",
            "fa-thumbs-down",
            "fa-thumbs-up",
            "fa-thumbtack",
            "fa-ticket-alt",
            "fa-times-circle",
            "fa-times",
            "fa-tint-slash",
            "fa-tint",
            "fa-tired",
            "fa-toggle-off",
            "fa-toggle-on",
            "fa-toolbox",
            "fa-tooth",
            "fa-trade-federation",
            "fa-trademark",
            "fa-train",
            "fa-transgender-alt",
            "fa-transgender",
            "fa-trash-alt",
            "fa-trash",
            "fa-tree",
            "fa-trello",
            "fa-tripadvisor",
            "fa-trophy",
            "fa-truck-loading",
            "fa-truck-moving",
            "fa-truck",
            "fa-tshirt",
            "fa-tty",
            "fa-tumblr-square",
            "fa-tumblr",
            "fa-tv",
            "fa-twitch",
            "fa-twitter-square",
            "fa-twitter",
            "fa-typo3",
            "fa-uber",
            "fa-uikit",
            "fa-umbrella-beach",
            "fa-umbrella",
            "fa-underline",
            "fa-undo-alt",
            "fa-undo",
            "fa-uniregistry",
            "fa-universal-access",
            "fa-university",
            "fa-unlink",
            "fa-unlock-alt",
            "fa-unlock",
            "fa-untappd",
            "fa-upload",
            "fa-usb",
            "fa-user-alt-slash",
            "fa-user-alt",
            "fa-user-astronaut",
            "fa-user-check",
            "fa-user-circle",
            "fa-user-clock",
            "fa-user-cog",
            "fa-user-edit",
            "fa-user-friends",
            "fa-user-graduate",
            "fa-user-lock",
            "fa-user-md",
            "fa-user-minus",
            "fa-user-ninja",
            "fa-user-plus",
            "fa-user-secret",
            "fa-user-shield",
            "fa-user-slash",
            "fa-user-tag",
            "fa-user-tie",
            "fa-user-times",
            "fa-user",
            "fa-users-cog",
            "fa-users",
            "fa-ussunnah",
            "fa-utensil-spoon",
            "fa-utensils",
            "fa-vaadin",
            "fa-vector-square",
            "fa-venus-double",
            "fa-venus-mars",
            "fa-venus",
            "fa-viacoin",
            "fa-viadeo-square",
            "fa-viadeo",
            "fa-vial",
            "fa-vials",
            "fa-viber",
            "fa-video-slash",
            "fa-video",
            "fa-vimeo-square",
            "fa-vimeo-v",
            "fa-vimeo",
            "fa-vine",
            "fa-vk",
            "fa-vnv",
            "fa-volleyball-ball",
            "fa-volume-down",
            "fa-volume-off",
            "fa-volume-up",
            "fa-vuejs",
            "fa-walking",
            "fa-wallet",
            "fa-warehouse",
            "fa-weebly",
            "fa-weibo",
            "fa-weight-hanging",
            "fa-weight",
            "fa-weixin",
            "fa-whatsapp-square",
            "fa-whatsapp",
            "fa-wheelchair",
            "fa-whmcs",
            "fa-wifi",
            "fa-wikipedia-w",
            "fa-window-close",
            "fa-window-maximize",
            "fa-window-minimize",
            "fa-window-restore",
            "fa-windows",
            "fa-wine-glass-alt",
            "fa-wine-glass",
            "fa-wix",
            "fa-wolf-pack-battalion",
            "fa-won-sign",
            "fa-wordpress-simple",
            "fa-wordpress",
            "fa-wpbeginner",
            "fa-wpexplorer",
            "fa-wpforms",
            "fa-wrench",
            "fa-x-ray",
            "fa-xbox",
            "fa-xing-square",
            "fa-xing",
            "fa-y-combinator",
            "fa-yahoo",
            "fa-yandex-international",
            "fa-yandex",
            "fa-yelp",
            "fa-yen-sign",
            "fa-yoast",
            "fa-youtube-square",
            "fa-youtube"
    };


    public List<ChoiceListValue> getChoiceListValues(ExtendedPropertyDefinition epd, String param, List<ChoiceListValue> values, Locale locale, Map<String, Object> context) {
        ArrayList<ChoiceListValue> results = new ArrayList<ChoiceListValue>();
        for (String t : ICONS) {
            results.add(new ChoiceListValue(t, t));
        }
        return results;
    }

    /**
     * {@inheritDoc}
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * {@inheritDoc}
     */
    public String getKey() {
        return key;
    }

    /**
     * {@inheritDoc}
     */
    public String getStringRendering(RenderContext context, JCRPropertyWrapper propertyWrapper) throws RepositoryException {
        final StringBuilder sb = new StringBuilder();

        if (propertyWrapper.isMultiple()) {
            sb.append('{');
            final Value[] values = propertyWrapper.getValues();
            for (Value value : values) {
                sb.append('[').append(value.getString()).append(']');
            }
            sb.append('}');
        } else {
            sb.append('[').append(propertyWrapper.getValue().getString()).append(']');
        }

        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    public String getStringRendering(Locale locale, ExtendedPropertyDefinition propDef, Object propertyValue) throws RepositoryException {
        return "[" + propertyValue.toString() + "]";
    }
}
