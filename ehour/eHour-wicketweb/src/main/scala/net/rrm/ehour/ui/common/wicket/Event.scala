package net.rrm.ehour.ui.common.wicket

import org.apache.wicket.Component
import org.apache.wicket.ajax.AjaxRequestTarget

class Event(val target: AjaxRequestTarget) {
  def refresh(components: Component*) {
    target.add(components: _*)
  }

  // for java compatibility
  def refresh(component: Component) {
    target.add(component)
  }
}
