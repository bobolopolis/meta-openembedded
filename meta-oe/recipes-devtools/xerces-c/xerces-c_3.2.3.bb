SUMMARY = "Xerces-c is a validating xml parser written in C++"
DESCRIPTION = "Xerces-C++ makes it easy to give your application \
               the ability to read and write XML data. \
               A shared library is provided for parsing, generating, \
               manipulating, and validating XML documents using \
               the DOM, SAX, and SAX2 APIs."
HOMEPAGE = "https://xerces.apache.org/xerces-c/"
SECTION =  "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "https://archive.apache.org/dist/xerces/c/3/sources/${BP}.tar.xz"
SRC_URI[sha256sum] = "12fc99a9fc1d1a79bd0e927b8b5637a576d6656f45b0d5e70ee3694d379cc149"

inherit cmake lib_package

PACKAGECONFIG ??= "curl icu"

PACKAGECONFIG[curl] = "-Dnetwork-accessor=curl,,curl,,,socket network-off"
PACKAGECONFIG[socket] = "-Dnetwork-accessor=socket,,,,,curl network-off"
PACKAGECONFIG[network-off] = "-Dnetwork:BOOL=OFF,,,,,curl socket"
PACKAGECONFIG[icu] = "-Dtranscoder=icu,,icu"

# The library .so is unversioned
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/libxerces-c-*.so"
FILES:${PN}-dev += "${libdir}/libxerces-c.so"

BBCLASSEXTEND = "native"
