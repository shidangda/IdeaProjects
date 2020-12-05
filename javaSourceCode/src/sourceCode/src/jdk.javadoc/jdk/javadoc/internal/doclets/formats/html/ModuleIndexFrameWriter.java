/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package jdk.javadoc.internal.doclets.formats.html;

import java.util.Map;
import java.util.Set;

import javax.lang.model.element.ModuleElement;
import javax.lang.model.element.PackageElement;

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlAttr;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlConstants;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTag;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
import jdk.javadoc.internal.doclets.formats.html.markup.RawHtml;
import jdk.javadoc.internal.doclets.formats.html.markup.StringContent;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocFileIOException;
import jdk.javadoc.internal.doclets.toolkit.util.DocLink;
import jdk.javadoc.internal.doclets.toolkit.util.DocPath;
import jdk.javadoc.internal.doclets.toolkit.util.DocPaths;

/**
 * Generate the module index for the left-hand frame in the generated output.
 * A click on the module name in this frame will update the page in the top
 * left hand frame with the listing of packages of the clicked module.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */
public class ModuleIndexFrameWriter extends AbstractModuleIndexWriter {

    /**
     * Construct the ModuleIndexFrameWriter object.
     *
     * @param configuration the configuration object
     * @param filename Name of the module index file to be generated.
     */
    public ModuleIndexFrameWriter(HtmlConfiguration configuration,
                                   DocPath filename) {
        super(configuration, filename);
    }

    /**
     * Generate the module index file named "module-overview-frame.html".
     * @throws DocFileIOException
     * @param configuration the configuration object
     */
    public static void generate(HtmlConfiguration configuration) throws DocFileIOException {
        DocPath filename = DocPaths.MODULE_OVERVIEW_FRAME;
        ModuleIndexFrameWriter modulegen = new ModuleIndexFrameWriter(configuration, filename);
        modulegen.buildModuleIndexFile("doclet.Window_Overview", false);
    }

    /**
     * {@inheritDoc}
     */
    protected void addModulesList(Content main) {
        Content heading = HtmlTree.HEADING(HtmlConstants.MODULE_HEADING, true,
                contents.modulesLabel);
        HtmlTree htmlTree = HtmlTree.DIV(HtmlStyle.indexContainer, heading);
        HtmlTree ul = new HtmlTree(HtmlTag.UL);
        ul.setTitle(contents.modulesLabel);
        for (ModuleElement mdle: configuration.modules) {
            ul.addContent(getModuleLink(mdle));
        }
        htmlTree.addContent(ul);
        main.addContent(htmlTree);
    }

    /**
     * Returns each module name as a separate link.
     *
     * @param mdle the module being documented
     * @return content for the module link
     */
    protected Content getModuleLink(ModuleElement mdle) {
        Content moduleLinkContent;
        Content mdlLabel = new StringContent(mdle.getQualifiedName());
        moduleLinkContent = getModuleFramesHyperLink(mdle, mdlLabel, "packageListFrame");
        Content li = HtmlTree.LI(moduleLinkContent);
        return li;
    }

    private Content getModuleFramesHyperLink(ModuleElement mdle, Content label, String target) {
        DocLink mdlLink = new DocLink(docPaths.moduleFrame(mdle));
        DocLink mtFrameLink = new DocLink(docPaths.moduleTypeFrame(mdle));
        DocLink cFrameLink = new DocLink(docPaths.moduleSummary(mdle));
        HtmlTree anchor = HtmlTree.A(mdlLink.toString(), label);
        String onclickStr = "updateModuleFrame('" + mtFrameLink + "','" + cFrameLink + "');";
        anchor.addAttr(HtmlAttr.TARGET, target);
        anchor.addAttr(HtmlAttr.ONCLICK, onclickStr);
        return anchor;
    }

    /**
     * {@inheritDoc}
     */
    protected void addNavigationBarHeader(Content header) {
        Content headerContent;
        if (configuration.packagesheader.length() > 0) {
            headerContent = new RawHtml(replaceDocRootDir(configuration.packagesheader));
        } else {
            headerContent = new RawHtml(replaceDocRootDir(configuration.header));
        }
        Content heading = HtmlTree.HEADING(HtmlConstants.TITLE_HEADING, true,
                HtmlStyle.bar, headerContent);
        header.addContent(heading);
    }

    /**
     * Do nothing as there is no overview information in this page.
     */
    protected void addOverviewHeader(Content body) {
    }

    /**
     * Adds "All Classes" link for the top of the left-hand frame page to the
     * documentation tree.
     *
     * @param ul the Content object to which the all classes link should be added
     */
    protected void addAllClassesLink(Content ul) {
        Content linkContent = links.createLink(DocPaths.ALLCLASSES_FRAME,
                contents.allClassesLabel, "", "packageFrame");
        Content li = HtmlTree.LI(linkContent);
        ul.addContent(li);
    }

    /**
     * Adds "All Packages" link for the top of the left-hand frame page to the
     * documentation tree.
     *
     * @param ul the Content object to which the all packages link should be added
     */
    protected void addAllPackagesLink(Content ul) {
        Content linkContent = links.createLink(DocPaths.OVERVIEW_FRAME,
                contents.allPackagesLabel, "", "packageListFrame");
        Content li = HtmlTree.LI(linkContent);
        ul.addContent(li);
    }

    /**
     * {@inheritDoc}
     */
    protected void addNavigationBarFooter(Content footer) {
        Content p = HtmlTree.P(Contents.SPACE);
        footer.addContent(p);
    }

    protected void addModulePackagesList(Map<ModuleElement, Set<PackageElement>> modules, String text,
            String tableSummary, Content main, ModuleElement mdle) {
    }
}
