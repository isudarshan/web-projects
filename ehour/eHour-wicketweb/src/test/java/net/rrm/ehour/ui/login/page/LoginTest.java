/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package net.rrm.ehour.ui.login.page;

import com.google.common.base.Optional;
import net.rrm.ehour.config.service.ConfigurationService;
import net.rrm.ehour.sysinfo.SystemInfo;
import net.rrm.ehour.sysinfo.SystemInfoService;
import net.rrm.ehour.ui.common.BaseSpringWebAppTester;
import net.rrm.ehour.ui.common.page.DummyPage;
import net.rrm.ehour.ui.common.util.AuthUtil;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.tester.FormTester;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest extends BaseSpringWebAppTester {

    @Mock
    private AuthUtil authUtil;

    @Mock
    private ConfigurationService configService;

    @Mock
    private SystemInfoService infoService;

    @Override
    protected AuthUtil buildAuthUtil() {
        return authUtil;
    }

    @Before
    public void setupMocks() throws Exception {
        getMockContext().putBean("configService", configService);
        getMockContext().putBean(infoService);
    }

    @Test
    public void shouldLoginPageRender() {
        tester.startPage(Login.class);
        tester.assertRenderedPage(Login.class);
        tester.assertNoErrorMessage();

        when(infoService.info()).thenReturn(new SystemInfo("a", "b", "c"));
        when(authUtil.getHomepageForRole(any(Roles.class))).thenReturn(new AuthUtil.Homepage(DummyPage.class, Optional.<PageParameters>absent()));

        FormTester form = tester.newFormTester("loginform");
        form.setValue("username", "thies");
        form.setValue("password", "Ttst");
        form.submit();

        tester.assertNoErrorMessage();
        tester.assertRenderedPage(DummyPage.class);
    }
}
