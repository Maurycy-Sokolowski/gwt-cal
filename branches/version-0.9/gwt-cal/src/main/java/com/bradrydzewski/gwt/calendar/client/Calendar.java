/*
 * This file is part of gwt-cal
 * Copyright (C) 2009  Scottsdale Software LLC
 * 
 * gwt-cal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/
 */

package com.bradrydzewski.gwt.calendar.client;

import com.bradrydzewski.gwt.calendar.client.dayview.DayView;
import com.google.gwt.user.client.Element;

public class Calendar extends CalendarWidget {

	
	private DayView dayView = null;
	private AgendaView agendaView = null;
	
	public static final int DAY_VIEW = 0;
	public static final int AGENDA_VIEW = 1;
	public static final int MONTH_VIEW = 2;


	public Calendar() {
		this(DAY_VIEW);
	}
	
	public Calendar(int view) {
		//super(new DayView());
		super();
		//setView(view);
	}
	
	public void setView(int view) {
		setView(view, getDays());
	}
	
	public void setView(int view, int days) {
		
		switch(view) {
			
			case 0 : {
				if(dayView==null)
					dayView = new DayView();
					dayView.setDays(days);
				this.view = dayView;
				break;
			}
			case 1 : {
				//if(agendaView==null)
				//TODO: need to cache agendaView, but there is a layout bug after a calendar item is deleted.
					agendaView = new AgendaView();
				this.view = agendaView;
				break;
			}
			case 2 : {
				this.view = new MonthView();
			}
			
		}
		
		//clear currently displayed items
		getRootPanel().clear();
		
		//set the style for the calendar, based on the selected view
		setStyleName(this.view.getStyleName());
		
		//attach view to the Calendar
		this.view.attach(this);
		//do required sizing and layout
		this.refresh();
	}


}
 