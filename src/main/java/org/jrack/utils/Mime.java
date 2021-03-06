package org.jrack.utils;

import org.jrack.Context;
import org.jrack.context.MapContext;

/**
 * a lookup table from file extension to mime type
 * <p/>
 * shamelessly based on https://github.com/rack/rack/blob/master/lib/rack/mime.rb
 * and: https://github.com/rack4java/rack4java-util
 */
public class Mime {
    public static final String DEFAULT_MIME_TYPE = "application/octet-stream";

    @SuppressWarnings("unchecked")
    public static final Context<String> MIME_TYPES = new MapContext<String>()
            .with(".123", "application/vnd.lotus-1-2-3")
            .with(".3dml", "text/vnd.in3d.3dml")
            .with(".3g2", "video/3gpp2")
            .with(".3gp", "video/3gpp")
            .with(".a", "application/octet-stream")
            .with(".acc", "application/vnd.americandynamics.acc")
            .with(".ace", "application/x-ace-compressed")
            .with(".acu", "application/vnd.acucobol")
            .with(".aep", "application/vnd.audiograph")
            .with(".afp", "application/vnd.ibm.modcap")
            .with(".ai", "application/postscript")
            .with(".aif", "audio/x-aiff")
            .with(".aiff", "audio/x-aiff")
            .with(".ami", "application/vnd.amiga.ami")
            .with(".appcache", "text/cache-manifest")
            .with(".apr", "application/vnd.lotus-approach")
            .with(".asc", "application/pgp-signature")
            .with(".asf", "video/x-ms-asf")
            .with(".asm", "text/x-asm")
            .with(".aso", "application/vnd.accpac.simply.aso")
            .with(".asx", "video/x-ms-asf")
            .with(".atc", "application/vnd.acucorp")
            .with(".atom", "application/atom+xml")
            .with(".atomcat", "application/atomcat+xml")
            .with(".atomsvc", "application/atomsvc+xml")
            .with(".atx", "application/vnd.antix.game-component")
            .with(".au", "audio/basic")
            .with(".avi", "video/x-msvideo")
            .with(".bat", "application/x-msdownload")
            .with(".bcpio", "application/x-bcpio")
            .with(".bdm", "application/vnd.syncml.dm+wbxml")
            .with(".bh2", "application/vnd.fujitsu.oasysprs")
            .with(".bin", "application/octet-stream")
            .with(".bmi", "application/vnd.bmi")
            .with(".bmp", "image/bmp")
            .with(".box", "application/vnd.previewsystems.box")
            .with(".btif", "image/prs.btif")
            .with(".bz", "application/x-bzip")
            .with(".bz2", "application/x-bzip2")
            .with(".c", "text/x-c")
            .with(".c4g", "application/vnd.clonk.c4group")
            .with(".cab", "application/vnd.ms-cab-compressed")
            .with(".cc", "text/x-c")
            .with(".ccxml", "application/ccxml+xml")
            .with(".cdbcmsg", "application/vnd.contact.cmsg")
            .with(".cdkey", "application/vnd.mediastation.cdkey")
            .with(".cdx", "chemical/x-cdx")
            .with(".cdxml", "application/vnd.chemdraw+xml")
            .with(".cdy", "application/vnd.cinderella")
            .with(".cer", "application/pkix-cert")
            .with(".cgm", "image/cgm")
            .with(".chat", "application/x-chat")
            .with(".chm", "application/vnd.ms-htmlhelp")
            .with(".chrt", "application/vnd.kde.kchart")
            .with(".cif", "chemical/x-cif")
            .with(".cii", "application/vnd.anser-web-certificate-issue-initiation")
            .with(".cil", "application/vnd.ms-artgalry")
            .with(".cla", "application/vnd.claymore")
            .with(".class", "application/octet-stream")
            .with(".clkk", "application/vnd.crick.clicker.keyboard")
            .with(".clkp", "application/vnd.crick.clicker.palette")
            .with(".clkt", "application/vnd.crick.clicker.template")
            .with(".clkw", "application/vnd.crick.clicker.wordbank")
            .with(".clkx", "application/vnd.crick.clicker")
            .with(".clp", "application/x-msclip")
            .with(".cmc", "application/vnd.cosmocaller")
            .with(".cmdf", "chemical/x-cmdf")
            .with(".cml", "chemical/x-cml")
            .with(".cmp", "application/vnd.yellowriver-custom-menu")
            .with(".cmx", "image/x-cmx")
            .with(".com", "application/x-msdownload")
            .with(".conf", "text/plain")
            .with(".cpio", "application/x-cpio")
            .with(".cpp", "text/x-c")
            .with(".cpt", "application/mac-compactpro")
            .with(".crd", "application/x-mscardfile")
            .with(".crl", "application/pkix-crl")
            .with(".crt", "application/x-x509-ca-cert")
            .with(".csh", "application/x-csh")
            .with(".csml", "chemical/x-csml")
            .with(".csp", "application/vnd.commonspace")
            .with(".css", "text/css")
            .with(".csv", "text/csv")
            .with(".curl", "application/vnd.curl")
            .with(".cww", "application/prs.cww")
            .with(".cxx", "text/x-c")
            .with(".daf", "application/vnd.mobius.daf")
            .with(".davmount", "application/davmount+xml")
            .with(".dcr", "application/x-director")
            .with(".dd2", "application/vnd.oma.dd2+xml")
            .with(".ddd", "application/vnd.fujixerox.ddd")
            .with(".deb", "application/x-debian-package")
            .with(".der", "application/x-x509-ca-cert")
            .with(".dfac", "application/vnd.dreamfactory")
            .with(".diff", "text/x-diff")
            .with(".dis", "application/vnd.mobius.dis")
            .with(".djv", "image/vnd.djvu")
            .with(".djvu", "image/vnd.djvu")
            .with(".dll", "application/x-msdownload")
            .with(".dmg", "application/octet-stream")
            .with(".dna", "application/vnd.dna")
            .with(".doc", "application/msword")
            .with(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
            .with(".dot", "application/msword")
            .with(".dp", "application/vnd.osgi.dp")
            .with(".dpg", "application/vnd.dpgraph")
            .with(".dsc", "text/prs.lines.tag")
            .with(".dtd", "application/xml-dtd")
            .with(".dts", "audio/vnd.dts")
            .with(".dtshd", "audio/vnd.dts.hd")
            .with(".dv", "video/x-dv")
            .with(".dvi", "application/x-dvi")
            .with(".dwf", "model/vnd.dwf")
            .with(".dwg", "image/vnd.dwg")
            .with(".dxf", "image/vnd.dxf")
            .with(".dxp", "application/vnd.spotfire.dxp")
            .with(".ear", "application/java-archive")
            .with(".ecelp4800", "audio/vnd.nuera.ecelp4800")
            .with(".ecelp7470", "audio/vnd.nuera.ecelp7470")
            .with(".ecelp9600", "audio/vnd.nuera.ecelp9600")
            .with(".ecma", "application/ecmascript")
            .with(".edm", "application/vnd.novadigm.edm")
            .with(".edx", "application/vnd.novadigm.edx")
            .with(".efif", "application/vnd.picsel")
            .with(".ei6", "application/vnd.pg.osasli")
            .with(".eml", "message/rfc822")
            .with(".eol", "audio/vnd.digital-winds")
            .with(".eot", "application/vnd.ms-fontobject")
            .with(".eps", "application/postscript")
            .with(".es3", "application/vnd.eszigno3+xml")
            .with(".esf", "application/vnd.epson.esf")
            .with(".etx", "text/x-setext")
            .with(".exe", "application/x-msdownload")
            .with(".ext", "application/vnd.novadigm.ext")
            .with(".ez", "application/andrew-inset")
            .with(".ez2", "application/vnd.ezpix-album")
            .with(".ez3", "application/vnd.ezpix-package")
            .with(".f", "text/x-fortran")
            .with(".f77", "text/x-fortran")
            .with(".f90", "text/x-fortran")
            .with(".fbs", "image/vnd.fastbidsheet")
            .with(".fdf", "application/vnd.fdf")
            .with(".fe_launch", "application/vnd.denovo.fcselayout-link")
            .with(".fg5", "application/vnd.fujitsu.oasysgp")
            .with(".fli", "video/x-fli")
            .with(".flo", "application/vnd.micrografx.flo")
            .with(".flv", "video/x-flv")
            .with(".flw", "application/vnd.kde.kivio")
            .with(".flx", "text/vnd.fmi.flexstor")
            .with(".fly", "text/vnd.fly")
            .with(".fm", "application/vnd.framemaker")
            .with(".fnc", "application/vnd.frogans.fnc")
            .with(".for", "text/x-fortran")
            .with(".fpx", "image/vnd.fpx")
            .with(".fsc", "application/vnd.fsc.weblaunch")
            .with(".fst", "image/vnd.fst")
            .with(".ftc", "application/vnd.fluxtime.clip")
            .with(".fti", "application/vnd.anser-web-funds-transfer-initiation")
            .with(".fvt", "video/vnd.fvt")
            .with(".fzs", "application/vnd.fuzzysheet")
            .with(".g3", "image/g3fax")
            .with(".gac", "application/vnd.groove-account")
            .with(".gdl", "model/vnd.gdl")
            .with(".gem", "application/octet-stream")
            .with(".gemspec", "text/x-script.ruby")
            .with(".ghf", "application/vnd.groove-help")
            .with(".gif", "image/gif")
            .with(".gim", "application/vnd.groove-identity-message")
            .with(".gmx", "application/vnd.gmx")
            .with(".gph", "application/vnd.flographit")
            .with(".gqf", "application/vnd.grafeq")
            .with(".gram", "application/srgs")
            .with(".grv", "application/vnd.groove-injector")
            .with(".grxml", "application/srgs+xml")
            .with(".gtar", "application/x-gtar")
            .with(".gtm", "application/vnd.groove-tool-message")
            .with(".gtw", "model/vnd.gtw")
            .with(".gv", "text/vnd.graphviz")
            .with(".gz", "application/x-gzip")
            .with(".h", "text/x-c")
            .with(".h261", "video/h261")
            .with(".h263", "video/h263")
            .with(".h264", "video/h264")
            .with(".hbci", "application/vnd.hbci")
            .with(".hdf", "application/x-hdf")
            .with(".hh", "text/x-c")
            .with(".hlp", "application/winhlp")
            .with(".hpgl", "application/vnd.hp-hpgl")
            .with(".hpid", "application/vnd.hp-hpid")
            .with(".hps", "application/vnd.hp-hps")
            .with(".hqx", "application/mac-binhex40")
            .with(".htc", "text/x-component")
            .with(".htke", "application/vnd.kenameaapp")
            .with(".htm", "text/html")
            .with(".html", "text/html")
            .with(".hvd", "application/vnd.yamaha.hv-dic")
            .with(".hvp", "application/vnd.yamaha.hv-voice")
            .with(".hvs", "application/vnd.yamaha.hv-script")
            .with(".icc", "application/vnd.iccprofile")
            .with(".ice", "x-conference/x-cooltalk")
            .with(".ico", "image/vnd.microsoft.icon")
            .with(".ics", "text/calendar")
            .with(".ief", "image/ief")
            .with(".ifb", "text/calendar")
            .with(".ifm", "application/vnd.shana.informed.formdata")
            .with(".igl", "application/vnd.igloader")
            .with(".igs", "model/iges")
            .with(".igx", "application/vnd.micrografx.igx")
            .with(".iif", "application/vnd.shana.informed.interchange")
            .with(".imp", "application/vnd.accpac.simply.imp")
            .with(".ims", "application/vnd.ms-ims")
            .with(".ipk", "application/vnd.shana.informed.package")
            .with(".irm", "application/vnd.ibm.rights-management")
            .with(".irp", "application/vnd.irepository.package+xml")
            .with(".iso", "application/octet-stream")
            .with(".itp", "application/vnd.shana.informed.formtemplate")
            .with(".ivp", "application/vnd.immervision-ivp")
            .with(".ivu", "application/vnd.immervision-ivu")
            .with(".jad", "text/vnd.sun.j2me.app-descriptor")
            .with(".jam", "application/vnd.jam")
            .with(".jar", "application/java-archive")
            .with(".java", "text/x-java-source")
            .with(".jisp", "application/vnd.jisp")
            .with(".jlt", "application/vnd.hp-jlyt")
            .with(".jnlp", "application/x-java-jnlp-file")
            .with(".joda", "application/vnd.joost.joda-archive")
            .with(".jp2", "image/jp2")
            .with(".jpeg", "image/jpeg")
            .with(".jpg", "image/jpeg")
            .with(".jpgv", "video/jpeg")
            .with(".jpm", "video/jpm")
            .with(".js", "application/javascript")
            .with(".json", "application/json")
            .with(".karbon", "application/vnd.kde.karbon")
            .with(".kfo", "application/vnd.kde.kformula")
            .with(".kia", "application/vnd.kidspiration")
            .with(".kml", "application/vnd.google-earth.kml+xml")
            .with(".kmz", "application/vnd.google-earth.kmz")
            .with(".kne", "application/vnd.kinar")
            .with(".kon", "application/vnd.kde.kontour")
            .with(".kpr", "application/vnd.kde.kpresenter")
            .with(".ksp", "application/vnd.kde.kspread")
            .with(".ktz", "application/vnd.kahootz")
            .with(".kwd", "application/vnd.kde.kword")
            .with(".latex", "application/x-latex")
            .with(".lbd", "application/vnd.llamagraphics.life-balance.desktop")
            .with(".lbe", "application/vnd.llamagraphics.life-balance.exchange+xml")
            .with(".les", "application/vnd.hhe.lesson-player")
            .with(".link66", "application/vnd.route66.link66+xml")
            .with(".log", "text/plain")
            .with(".lostxml", "application/lost+xml")
            .with(".lrm", "application/vnd.ms-lrm")
            .with(".ltf", "application/vnd.frogans.ltf")
            .with(".lvp", "audio/vnd.lucent.voice")
            .with(".lwp", "application/vnd.lotus-wordpro")
            .with(".m3u", "audio/x-mpegurl")
            .with(".m4a", "audio/mp4a-latm")
            .with(".m4v", "video/mp4")
            .with(".ma", "application/mathematica")
            .with(".mag", "application/vnd.ecowin.chart")
            .with(".man", "text/troff")
            .with(".manifest", "text/cache-manifest")
            .with(".mathml", "application/mathml+xml")
            .with(".mbk", "application/vnd.mobius.mbk")
            .with(".mbox", "application/mbox")
            .with(".mc1", "application/vnd.medcalcdata")
            .with(".mcd", "application/vnd.mcd")
            .with(".mdb", "application/x-msaccess")
            .with(".mdi", "image/vnd.ms-modi")
            .with(".mdoc", "text/troff")
            .with(".me", "text/troff")
            .with(".mfm", "application/vnd.mfmp")
            .with(".mgz", "application/vnd.proteus.magazine")
            .with(".mid", "audio/midi")
            .with(".midi", "audio/midi")
            .with(".mif", "application/vnd.mif")
            .with(".mime", "message/rfc822")
            .with(".mj2", "video/mj2")
            .with(".mlp", "application/vnd.dolby.mlp")
            .with(".mmd", "application/vnd.chipnuts.karaoke-mmd")
            .with(".mmf", "application/vnd.smaf")
            .with(".mml", "application/mathml+xml")
            .with(".mmr", "image/vnd.fujixerox.edmics-mmr")
            .with(".mng", "video/x-mng")
            .with(".mny", "application/x-msmoney")
            .with(".mov", "video/quicktime")
            .with(".movie", "video/x-sgi-movie")
            .with(".mp3", "audio/mpeg")
            .with(".mp4", "video/mp4")
            .with(".mp4a", "audio/mp4")
            .with(".mp4s", "application/mp4")
            .with(".mp4v", "video/mp4")
            .with(".mpc", "application/vnd.mophun.certificate")
            .with(".mpeg", "video/mpeg")
            .with(".mpg", "video/mpeg")
            .with(".mpga", "audio/mpeg")
            .with(".mpkg", "application/vnd.apple.installer+xml")
            .with(".mpm", "application/vnd.blueice.multipass")
            .with(".mpn", "application/vnd.mophun.application")
            .with(".mpp", "application/vnd.ms-project")
            .with(".mpy", "application/vnd.ibm.minipay")
            .with(".mqy", "application/vnd.mobius.mqy")
            .with(".mrc", "application/marc")
            .with(".ms", "text/troff")
            .with(".mscml", "application/mediaservercontrol+xml")
            .with(".mseq", "application/vnd.mseq")
            .with(".msf", "application/vnd.epson.msf")
            .with(".msh", "model/mesh")
            .with(".msi", "application/x-msdownload")
            .with(".msl", "application/vnd.mobius.msl")
            .with(".msty", "application/vnd.muvee.style")
            .with(".mts", "model/vnd.mts")
            .with(".mus", "application/vnd.musician")
            .with(".mvb", "application/x-msmediaview")
            .with(".mwf", "application/vnd.mfer")
            .with(".mxf", "application/mxf")
            .with(".mxl", "application/vnd.recordare.musicxml")
            .with(".mxml", "application/xv+xml")
            .with(".mxs", "application/vnd.triscape.mxs")
            .with(".mxu", "video/vnd.mpegurl")
            .with(".n", "application/vnd.nokia.n-gage.symbian.install")
            .with(".nc", "application/x-netcdf")
            .with(".ngdat", "application/vnd.nokia.n-gage.data")
            .with(".nlu", "application/vnd.neurolanguage.nlu")
            .with(".nml", "application/vnd.enliven")
            .with(".nnd", "application/vnd.noblenet-directory")
            .with(".nns", "application/vnd.noblenet-sealer")
            .with(".nnw", "application/vnd.noblenet-web")
            .with(".npx", "image/vnd.net-fpx")
            .with(".nsf", "application/vnd.lotus-notes")
            .with(".oa2", "application/vnd.fujitsu.oasys2")
            .with(".oa3", "application/vnd.fujitsu.oasys3")
            .with(".oas", "application/vnd.fujitsu.oasys")
            .with(".obd", "application/x-msbinder")
            .with(".oda", "application/oda")
            .with(".odc", "application/vnd.oasis.opendocument.chart")
            .with(".odf", "application/vnd.oasis.opendocument.formula")
            .with(".odg", "application/vnd.oasis.opendocument.graphics")
            .with(".odi", "application/vnd.oasis.opendocument.image")
            .with(".odp", "application/vnd.oasis.opendocument.presentation")
            .with(".ods", "application/vnd.oasis.opendocument.spreadsheet")
            .with(".odt", "application/vnd.oasis.opendocument.text")
            .with(".oga", "audio/ogg")
            .with(".ogg", "application/ogg")
            .with(".ogv", "video/ogg")
            .with(".ogx", "application/ogg")
            .with(".org", "application/vnd.lotus-organizer")
            .with(".otc", "application/vnd.oasis.opendocument.chart-template")
            .with(".otf", "application/vnd.oasis.opendocument.formula-template")
            .with(".otg", "application/vnd.oasis.opendocument.graphics-template")
            .with(".oth", "application/vnd.oasis.opendocument.text-web")
            .with(".oti", "application/vnd.oasis.opendocument.image-template")
            .with(".otm", "application/vnd.oasis.opendocument.text-master")
            .with(".ots", "application/vnd.oasis.opendocument.spreadsheet-template")
            .with(".ott", "application/vnd.oasis.opendocument.text-template")
            .with(".oxt", "application/vnd.openofficeorg.extension")
            .with(".p", "text/x-pascal")
            .with(".p10", "application/pkcs10")
            .with(".p12", "application/x-pkcs12")
            .with(".p7b", "application/x-pkcs7-certificates")
            .with(".p7m", "application/pkcs7-mime")
            .with(".p7r", "application/x-pkcs7-certreqresp")
            .with(".p7s", "application/pkcs7-signature")
            .with(".pas", "text/x-pascal")
            .with(".pbd", "application/vnd.powerbuilder6")
            .with(".pbm", "image/x-portable-bitmap")
            .with(".pcl", "application/vnd.hp-pcl")
            .with(".pclxl", "application/vnd.hp-pclxl")
            .with(".pcx", "image/x-pcx")
            .with(".pdb", "chemical/x-pdb")
            .with(".pdf", "application/pdf")
            .with(".pem", "application/x-x509-ca-cert")
            .with(".pfr", "application/font-tdpfr")
            .with(".pgm", "image/x-portable-graymap")
            .with(".pgn", "application/x-chess-pgn")
            .with(".pgp", "application/pgp-encrypted")
            .with(".pic", "image/x-pict")
            .with(".pict", "image/pict")
            .with(".pkg", "application/octet-stream")
            .with(".pki", "application/pkixcmp")
            .with(".pkipath", "application/pkix-pkipath")
            .with(".pl", "text/x-script.perl")
            .with(".plb", "application/vnd.3gpp.pic-bw-large")
            .with(".plc", "application/vnd.mobius.plc")
            .with(".plf", "application/vnd.pocketlearn")
            .with(".pls", "application/pls+xml")
            .with(".pm", "text/x-script.perl-module")
            .with(".pml", "application/vnd.ctc-posml")
            .with(".png", "image/png")
            .with(".pnm", "image/x-portable-anymap")
            .with(".pntg", "image/x-macpaint")
            .with(".portpkg", "application/vnd.macports.portpkg")
            .with(".ppd", "application/vnd.cups-ppd")
            .with(".ppm", "image/x-portable-pixmap")
            .with(".pps", "application/vnd.ms-powerpoint")
            .with(".ppt", "application/vnd.ms-powerpoint")
            .with(".prc", "application/vnd.palm")
            .with(".pre", "application/vnd.lotus-freelance")
            .with(".prf", "application/pics-rules")
            .with(".ps", "application/postscript")
            .with(".psb", "application/vnd.3gpp.pic-bw-small")
            .with(".psd", "image/vnd.adobe.photoshop")
            .with(".ptid", "application/vnd.pvi.ptid1")
            .with(".pub", "application/x-mspublisher")
            .with(".pvb", "application/vnd.3gpp.pic-bw-var")
            .with(".pwn", "application/vnd.3m.post-it-notes")
            .with(".py", "text/x-script.python")
            .with(".pya", "audio/vnd.ms-playready.media.pya")
            .with(".pyv", "video/vnd.ms-playready.media.pyv")
            .with(".qam", "application/vnd.epson.quickanime")
            .with(".qbo", "application/vnd.intu.qbo")
            .with(".qfx", "application/vnd.intu.qfx")
            .with(".qps", "application/vnd.publishare-delta-tree")
            .with(".qt", "video/quicktime")
            .with(".qtif", "image/x-quicktime")
            .with(".qxd", "application/vnd.quark.quarkxpress")
            .with(".ra", "audio/x-pn-realaudio")
            .with(".rake", "text/x-script.ruby")
            .with(".ram", "audio/x-pn-realaudio")
            .with(".rar", "application/x-rar-compressed")
            .with(".ras", "image/x-cmu-raster")
            .with(".rb", "text/x-script.ruby")
            .with(".rcprofile", "application/vnd.ipunplugged.rcprofile")
            .with(".rdf", "application/rdf+xml")
            .with(".rdz", "application/vnd.data-vision.rdz")
            .with(".rep", "application/vnd.businessobjects")
            .with(".rgb", "image/x-rgb")
            .with(".rif", "application/reginfo+xml")
            .with(".rl", "application/resource-lists+xml")
            .with(".rlc", "image/vnd.fujixerox.edmics-rlc")
            .with(".rld", "application/resource-lists-diff+xml")
            .with(".rm", "application/vnd.rn-realmedia")
            .with(".rmp", "audio/x-pn-realaudio-plugin")
            .with(".rms", "application/vnd.jcp.javame.midlet-rms")
            .with(".rnc", "application/relax-ng-compact-syntax")
            .with(".roff", "text/troff")
            .with(".rpm", "application/x-redhat-package-manager")
            .with(".rpss", "application/vnd.nokia.radio-presets")
            .with(".rpst", "application/vnd.nokia.radio-preset")
            .with(".rq", "application/sparql-query")
            .with(".rs", "application/rls-services+xml")
            .with(".rsd", "application/rsd+xml")
            .with(".rss", "application/rss+xml")
            .with(".rtf", "application/rtf")
            .with(".rtx", "text/richtext")
            .with(".ru", "text/x-script.ruby")
            .with(".s", "text/x-asm")
            .with(".saf", "application/vnd.yamaha.smaf-audio")
            .with(".sbml", "application/sbml+xml")
            .with(".sc", "application/vnd.ibm.secure-container")
            .with(".scd", "application/x-msschedule")
            .with(".scm", "application/vnd.lotus-screencam")
            .with(".scq", "application/scvp-cv-request")
            .with(".scs", "application/scvp-cv-response")
            .with(".sdkm", "application/vnd.solent.sdkm+xml")
            .with(".sdp", "application/sdp")
            .with(".see", "application/vnd.seemail")
            .with(".sema", "application/vnd.sema")
            .with(".semd", "application/vnd.semd")
            .with(".semf", "application/vnd.semf")
            .with(".setpay", "application/set-payment-initiation")
            .with(".setreg", "application/set-registration-initiation")
            .with(".sfd", "application/vnd.hydrostatix.sof-data")
            .with(".sfs", "application/vnd.spotfire.sfs")
            .with(".sgm", "text/sgml")
            .with(".sgml", "text/sgml")
            .with(".sh", "application/x-sh")
            .with(".shar", "application/x-shar")
            .with(".shf", "application/shf+xml")
            .with(".sig", "application/pgp-signature")
            .with(".sit", "application/x-stuffit")
            .with(".sitx", "application/x-stuffitx")
            .with(".skp", "application/vnd.koan")
            .with(".slt", "application/vnd.epson.salt")
            .with(".smi", "application/smil+xml")
            .with(".snd", "audio/basic")
            .with(".so", "application/octet-stream")
            .with(".spf", "application/vnd.yamaha.smaf-phrase")
            .with(".spl", "application/x-futuresplash")
            .with(".spot", "text/vnd.in3d.spot")
            .with(".spp", "application/scvp-vp-response")
            .with(".spq", "application/scvp-vp-request")
            .with(".src", "application/x-wais-source")
            .with(".srx", "application/sparql-results+xml")
            .with(".sse", "application/vnd.kodak-descriptor")
            .with(".ssf", "application/vnd.epson.ssf")
            .with(".ssml", "application/ssml+xml")
            .with(".stf", "application/vnd.wt.stf")
            .with(".stk", "application/hyperstudio")
            .with(".str", "application/vnd.pg.format")
            .with(".sus", "application/vnd.sus-calendar")
            .with(".sv4cpio", "application/x-sv4cpio")
            .with(".sv4crc", "application/x-sv4crc")
            .with(".svd", "application/vnd.svd")
            .with(".svg", "image/svg+xml")
            .with(".svgz", "image/svg+xml")
            .with(".swf", "application/x-shockwave-flash")
            .with(".swi", "application/vnd.arastra.swi")
            .with(".t", "text/troff")
            .with(".tao", "application/vnd.tao.intent-module-archive")
            .with(".tar", "application/x-tar")
            .with(".tbz", "application/x-bzip-compressed-tar")
            .with(".tcap", "application/vnd.3gpp2.tcap")
            .with(".tcl", "application/x-tcl")
            .with(".tex", "application/x-tex")
            .with(".texi", "application/x-texinfo")
            .with(".texinfo", "application/x-texinfo")
            .with(".text", "text/plain")
            .with(".tif", "image/tiff")
            .with(".tiff", "image/tiff")
            .with(".tmo", "application/vnd.tmobile-livetv")
            .with(".torrent", "application/x-bittorrent")
            .with(".tpl", "application/vnd.groove-tool-template")
            .with(".tpt", "application/vnd.trid.tpt")
            .with(".tr", "text/troff")
            .with(".tra", "application/vnd.trueapp")
            .with(".trm", "application/x-msterminal")
            .with(".tsv", "text/tab-separated-values")
            .with(".ttf", "application/octet-stream")
            .with(".twd", "application/vnd.simtech-mindmapper")
            .with(".txd", "application/vnd.genomatix.tuxedo")
            .with(".txf", "application/vnd.mobius.txf")
            .with(".txt", "text/plain")
            .with(".ufd", "application/vnd.ufdl")
            .with(".umj", "application/vnd.umajin")
            .with(".unityweb", "application/vnd.unity")
            .with(".uoml", "application/vnd.uoml+xml")
            .with(".uri", "text/uri-list")
            .with(".ustar", "application/x-ustar")
            .with(".utz", "application/vnd.uiq.theme")
            .with(".uu", "text/x-uuencode")
            .with(".vcd", "application/x-cdlink")
            .with(".vcf", "text/x-vcard")
            .with(".vcg", "application/vnd.groove-vcard")
            .with(".vcs", "text/x-vcalendar")
            .with(".vcx", "application/vnd.vcx")
            .with(".vis", "application/vnd.visionary")
            .with(".viv", "video/vnd.vivo")
            .with(".vrml", "model/vrml")
            .with(".vsd", "application/vnd.visio")
            .with(".vsf", "application/vnd.vsf")
            .with(".vtu", "model/vnd.vtu")
            .with(".vxml", "application/voicexml+xml")
            .with(".war", "application/java-archive")
            .with(".wav", "audio/x-wav")
            .with(".wax", "audio/x-ms-wax")
            .with(".wbmp", "image/vnd.wap.wbmp")
            .with(".wbs", "application/vnd.criticaltools.wbs+xml")
            .with(".wbxml", "application/vnd.wap.wbxml")
            .with(".webm", "video/webm")
            .with(".wm", "video/x-ms-wm")
            .with(".wma", "audio/x-ms-wma")
            .with(".wmd", "application/x-ms-wmd")
            .with(".wmf", "application/x-msmetafile")
            .with(".wml", "text/vnd.wap.wml")
            .with(".wmlc", "application/vnd.wap.wmlc")
            .with(".wmls", "text/vnd.wap.wmlscript")
            .with(".wmlsc", "application/vnd.wap.wmlscriptc")
            .with(".wmv", "video/x-ms-wmv")
            .with(".wmx", "video/x-ms-wmx")
            .with(".wmz", "application/x-ms-wmz")
            .with(".woff", "application/octet-stream")
            .with(".wpd", "application/vnd.wordperfect")
            .with(".wpl", "application/vnd.ms-wpl")
            .with(".wps", "application/vnd.ms-works")
            .with(".wqd", "application/vnd.wqd")
            .with(".wri", "application/x-mswrite")
            .with(".wrl", "model/vrml")
            .with(".wsdl", "application/wsdl+xml")
            .with(".wspolicy", "application/wspolicy+xml")
            .with(".wtb", "application/vnd.webturbo")
            .with(".wvx", "video/x-ms-wvx")
            .with(".x3d", "application/vnd.hzn-3d-crossword")
            .with(".xar", "application/vnd.xara")
            .with(".xbd", "application/vnd.fujixerox.docuworks.binder")
            .with(".xbm", "image/x-xbitmap")
            .with(".xdm", "application/vnd.syncml.dm+xml")
            .with(".xdp", "application/vnd.adobe.xdp+xml")
            .with(".xdw", "application/vnd.fujixerox.docuworks")
            .with(".xenc", "application/xenc+xml")
            .with(".xer", "application/patch-ops-error+xml")
            .with(".xfdf", "application/vnd.adobe.xfdf")
            .with(".xfdl", "application/vnd.xfdl")
            .with(".xhtml", "application/xhtml+xml")
            .with(".xif", "image/vnd.xiff")
            .with(".xls", "application/vnd.ms-excel")
            .with(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
            .with(".xml", "application/xml")
            .with(".xo", "application/vnd.olpc-sugar")
            .with(".xop", "application/xop+xml")
            .with(".xpm", "image/x-xpixmap")
            .with(".xpr", "application/vnd.is-xpr")
            .with(".xps", "application/vnd.ms-xpsdocument")
            .with(".xpw", "application/vnd.intercon.formnet")
            .with(".xsl", "application/xml")
            .with(".xslt", "application/xslt+xml")
            .with(".xsm", "application/vnd.syncml+xml")
            .with(".xspf", "application/xspf+xml")
            .with(".xul", "application/vnd.mozilla.xul+xml")
            .with(".xwd", "image/x-xwindowdump")
            .with(".xyz", "chemical/x-xyz")
            .with(".yaml", "text/yaml")
            .with(".yml", "text/yaml")
            .with(".zaz", "application/vnd.zzazz.deck+xml")
            .with(".zip", "application/zip")
            .with(".zmm", "application/vnd.handheld-entertainment+xml");


    public static String mimeType(String ext) {
        return StringUtils.isBlank(ext) ? DEFAULT_MIME_TYPE :
                StringUtils.stringValue(MIME_TYPES.get(ext), DEFAULT_MIME_TYPE);
    }
}