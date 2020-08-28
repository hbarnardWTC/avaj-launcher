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
	}

	public void unregister(Flyable flyable){
	}

	protected void conditionsChanged(){
	}
}