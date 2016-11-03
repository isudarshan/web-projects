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

package net.rrm.ehour.ui.timesheet.dto;

import net.rrm.ehour.domain.ProjectAssignment;
import net.rrm.ehour.domain.TimesheetEntry;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Representation of a cell (day in a project) in the timesheet
 */

public class TimesheetCell implements Comparable<TimesheetCell>, Serializable {
    private static final long serialVersionUID = -2708559856313387714L;
    private TimesheetEntry timesheetEntry;
    private boolean locked;
    private Date date;
    private ProjectAssignment projectAssignment;

    public TimesheetCell(TimesheetEntry timesheetEntry, boolean locked, Date date, ProjectAssignment projectAssignment) {
        this.timesheetEntry = timesheetEntry;
        this.locked = locked;
        this.date = date;
        this.projectAssignment = projectAssignment;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isWithHours() {
        return timesheetEntry != null && !timesheetEntry.isEmptyEntry();
    }

    public TimesheetEntry getTimesheetEntry() {
        return timesheetEntry;
    }

    public void setTimesheetEntry(TimesheetEntry timesheetEntry) {
        this.timesheetEntry = timesheetEntry;
    }

    public ProjectAssignment getProjectAssignment() {
        return projectAssignment;
    }

    @Override
    public int compareTo(TimesheetCell o) {
        return getTimesheetEntry().getEntryId().getEntryDate().compareTo(o.getTimesheetEntry().getEntryId().getEntryDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimesheetCell that = (TimesheetCell) o;

        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(timesheetEntry, that.timesheetEntry)) return false;
        if (!Objects.equals(projectAssignment, that.projectAssignment)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = timesheetEntry.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
