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

package net.rrm.ehour.ui.report.aggregate.node;

import net.rrm.ehour.report.reports.element.AssignmentAggregateReportElement;
import net.rrm.ehour.report.reports.element.ReportElement;
import net.rrm.ehour.ui.report.model.ReportNode;

import java.io.Serializable;

/**
 * Customer node in report
 */

public class CustomerNode extends ReportNode {
    private static final long serialVersionUID = -356525734449023397L;

    public CustomerNode(AssignmentAggregateReportElement aggregate) {
        super(aggregate.getProjectAssignment().getProject().getCustomer().getPK(), aggregate.isEmptyEntry());

        if (aggregate.getProjectAssignment() != null) {
            this.columnValues = new String[]{aggregate.getProjectAssignment().getProject().getCustomer().getFullName()};
        }
    }

    @Override
    protected Serializable getElementId(ReportElement element) {
        AssignmentAggregateReportElement aggregate = (AssignmentAggregateReportElement) element;

        return aggregate.getProjectAssignment() != null ? aggregate.getProjectAssignment().getProject().getCustomer().getPK() : Integer.valueOf(1);
    }
}