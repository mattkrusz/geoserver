/* (c) 2016 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.web.security.oauth2;

import java.util.logging.Logger;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.geoserver.security.oauth2.GeoServerOAuthAuthenticationFilter;
import org.geoserver.security.oauth2.OAuth2FilterConfig;
import org.geoserver.security.web.auth.PreAuthenticatedUserNameFilterPanel;
import org.geoserver.web.wicket.GeoServerDialog;
import org.geoserver.web.wicket.HelpLink;
import org.geotools.util.logging.Logging;

/**
 * Configuration panel for {@link GeoServerOAuthAuthenticationFilter}.
 * 
 * @author Alessio Fabiani, GeoSolutions S.A.S.
 */
public class OAuth2AuthProviderPanel extends PreAuthenticatedUserNameFilterPanel<OAuth2FilterConfig> {

	private static final long serialVersionUID = 689778998902987791L;

	static Logger LOGGER = Logging.getLogger("org.geoserver.security");
	GeoServerDialog dialog;

	IModel<OAuth2FilterConfig> model;

	public OAuth2AuthProviderPanel(String id, IModel<OAuth2FilterConfig> model) {
		super(id, model);

		this.dialog = (GeoServerDialog) get("dialog");
		this.model = model;

		add(new HelpLink("connectionParametersHelp", this).setDialog(dialog));
		add(new HelpLink("accessTokenUriHelp", this).setDialog(dialog));
		add(new HelpLink("userAuthorizationUriHelp", this).setDialog(dialog));
		add(new HelpLink("redirectUriHelp", this).setDialog(dialog));
		add(new HelpLink("checkTokenEndpointUrlHelp", this).setDialog(dialog));
		add(new HelpLink("logoutUriHelp", this).setDialog(dialog));
		add(new HelpLink("scopesHelp", this).setDialog(dialog));
		add(new HelpLink("cliendIdHelp", this).setDialog(dialog));
		add(new HelpLink("clientSecretHelp", this).setDialog(dialog));

		add(new TextField<String>("accessTokenUri"));
		add(new TextField<String>("userAuthorizationUri"));
		add(new TextField<String>("redirectUri"));
		add(new TextField<String>("checkTokenEndpointUrl"));
		add(new TextField<String>("logoutUri"));
		add(new TextField<String>("scopes"));
		add(new TextField<String>("cliendId"));
		add(new TextField<String>("clientSecret"));
	}
}
