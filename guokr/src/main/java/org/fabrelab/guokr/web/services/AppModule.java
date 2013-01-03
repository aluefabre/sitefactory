package org.fabrelab.guokr.web.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Primary;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.ValueEncoderFactory;
import org.apache.tapestry5.services.linktransform.PageRenderLinkTransformer;
import org.fabrelab.guokr.web.formobjcet.GroupEncoder;
import org.fabrelab.guokr.web.formobjcet.SiteEncoder;
import org.fabrelab.guokr.web.formobjcet.TagEncoder;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.dal.dataobject.TagDO;
import org.got5.tapestry5.jquery.JQuerySymbolConstants;

/**
 * Application global configurations
 * 
 * @author Serge Eby
 * @version $Id$
 * 
 */
public class AppModule {
	public static void bind(ServiceBinder binder) {
		// binder.bind(MyServiceInterface.class, MyServiceImpl.class);

		// Make bind() calls on the binder object to define most IoC
		// services.
		// Use service builder methods (example below) when the
		// implementation
		// is provided inline, or requires more initialization than simply
		// invoking the constructor.
		binder.bind(SuffixRequestFilter.class, SuffixRequestFilter.class);
		binder.bind(MyCookieManager.class, MyCookieManager.class);

	}

	public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration) {
		configuration.add(SymbolConstants.SUPPORTED_LOCALES, "de,en,es,fr,it,ko,nl,no,pt_BR,pt,tr,zh_CN,zh_TW,en_US");

		configuration.add(SymbolConstants.APPLICATION_CATALOG, "WEB-INF/classes/ApplicationResources.properties");

		// The factory default is true but during the early stages of an
		// application
		// overriding to false is a good idea. In addition, this is often
		// overridden
		// on the command line as -Dtapestry.production-mode=false
		configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
		
		configuration.add(JQuerySymbolConstants.SUPPRESS_PROTOTYPE, "true");

		configuration.add(JQuerySymbolConstants.JQUERY_ALIAS, "$");
	}

	@Contribute(PageRenderLinkTransformer.class)
	@Primary
	public static void provideURLRewriting(OrderedConfiguration<PageRenderLinkTransformer> configuration) {
		configuration.addInstance("SuffixLinkTransformer", SuffixLinkTransformer.class);
	}

	public void contributeRequestHandler(OrderedConfiguration<RequestFilter> configuration, SuffixRequestFilter filter) {
		configuration.add("SuffixRequestFilter", filter);
	}

	public static void contributeValueEncoderSource(MappedConfiguration<Class, ValueEncoderFactory> configuration) {
		configuration.addInstance(TagDO.class, TagEncoder.class);
		configuration.addInstance(GroupDO.class, GroupEncoder.class);
		configuration.addInstance(SiteDO.class, SiteEncoder.class);
	}
}
