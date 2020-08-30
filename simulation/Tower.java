/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Tower.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hbarnard <wingarkorin@gmail.com>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/21 14:59:12 by hbarnard          #+#    #+#             */
/*   Updated: 2020/08/21 14:59:12 by hbarnard         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulation;

import java.util.ArrayList;
import aircraft.Flyable;

public abstract class Tower{

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable){
		if (!observers.contains(flyable)) {
			observers.add(flyable);
		} else {
			System.out.println("The new aircraft was already registered!");
		}
	}

	public void unregister(Flyable flyable){
		if (observers.contains(flyable)) {
			observers.remove(flyable);
		} else {
			System.out.println("That aircraft does not exist in our registered aircrafts");
		}
	}

	protected void conditionsChanged(){
		int i = 0;
		while (i < observers.size()) {
			observers.get(i).updateConditions();
			i++;
		}
	}
}