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

package net.rrm.ehour.ui.common.form;

import net.rrm.ehour.ui.common.component.JavaScriptConfirmation;
import net.rrm.ehour.ui.common.decorator.DemoDecorator;
import net.rrm.ehour.ui.common.decorator.LoadingSpinnerDecorator;
import net.rrm.ehour.ui.common.event.AjaxEvent;
import net.rrm.ehour.ui.common.event.EventPublisher;
import net.rrm.ehour.ui.common.event.PayloadAjaxEvent;
import net.rrm.ehour.ui.common.model.AdminBackingBean;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.ResourceModel;

import java.util.List;

/**
 * Common form stuff
 */
@SuppressWarnings("serial")
public class FormUtil {
    private FormUtil() {
    }

    public static void setSubmitActions(final FormConfig formConfig) {
        final boolean inDemoMode = formConfig.getConfig().isInDemoMode();

        AjaxButton submitButton = new AjaxButton("submitButton", formConfig.getForm()) {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                if (!inDemoMode) {
                    AdminBackingBean backingBean = (AdminBackingBean) formConfig.getForm().getDefaultModelObject();
                    PayloadAjaxEvent<AdminBackingBean> ajaxEvent = new PayloadAjaxEvent<>(formConfig.getSubmitEventType(), backingBean);

                    EventPublisher.publishAjaxEvent(formConfig.getSubmitTarget(), ajaxEvent);
                }
            }

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
                super.updateAjaxAttributes(attributes);

                attributes.getAjaxCallListeners().add(inDemoMode ? new DemoDecorator() : new LoadingSpinnerDecorator());
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
                target.add(form);

                if (formConfig.getErrorEventType() != null) {
                    AjaxEvent errorEvent = new AjaxEvent(formConfig.getErrorEventType());
                    EventPublisher.publishAjaxEvent(formConfig.getSubmitTarget(), errorEvent);
                }
            }
        };

        submitButton.setModel(new ResourceModel("general.save"));
        // default submit
        formConfig.getForm().add(submitButton);

        AjaxLink<Void> deleteButton = new AjaxLink<Void>("deleteButton") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                if (!inDemoMode) {
                    AdminBackingBean backingBean = (AdminBackingBean) formConfig.getForm().getDefaultModelObject();
                    PayloadAjaxEvent<AdminBackingBean> ajaxEvent = new PayloadAjaxEvent<>(formConfig.getDeleteEventType(), backingBean);

                    EventPublisher.publishAjaxEvent(formConfig.getSubmitTarget(), ajaxEvent);
                }
            }

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
                super.updateAjaxAttributes(attributes);

                List<IAjaxCallListener> callListeners = attributes.getAjaxCallListeners();

                if (inDemoMode) {
                    callListeners.add(new DemoDecorator());
                } else {
                    callListeners.add(new JavaScriptConfirmation(new ResourceModel("general.deleteConfirmation")));
                    callListeners.add(new LoadingSpinnerDecorator());
                }
            }
        };

        deleteButton.setVisible(formConfig.isIncludeDelete());
        formConfig.getForm().add(deleteButton);
    }
}
