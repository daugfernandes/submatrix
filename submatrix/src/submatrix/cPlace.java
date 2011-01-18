/*
 *
 *     Copyright (C) 2010  David Fernandes
 *
 *                         Rua da Quinta Amarela, 60
 *                         4475-663 MAIA
 *                         PORTUGAL
 *
 *                         <daugfernandes@aim.com>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package submatrix;

import java.util.ArrayList;

/*

    submatrix::cPlace.java

 */
/**
 *
 * @author david
 */
public class cPlace {

    private ArrayList<cCreature> _creatures;
    private cRealm _realm;

    /**
     *
     */
    public cPlace() {
        setCreatures(new ArrayList<cCreature>(0));
        _realm = null;
    }

    /**
     *
     * @param p_realm
     */
    public cPlace(cRealm p_realm) {
        setCreatures(new ArrayList<cCreature>(0));
        _realm = p_realm;
    }

    /**
     *
     * @param p_creature
     */
    public cPlace(cCreature p_creature) {
        getCreatures().add(p_creature);
    }

    /**
     *
     * @return
     */
    public ArrayList<cCreature> getCreatures() {
        return _creatures;
    }

    /**
     *
     * @param p_creatures
     */
    public void setCreatures(ArrayList<cCreature> p_creatures) {
        _creatures=p_creatures;
        for(int i=0;i<_creatures.size();i++) {
            _creatures.get(i).setActualRealm(_realm);
        }
    }

    /**
     *
     * @param p_creature
     */
    public void addCreature(cCreature p_creature) {
        p_creature.setActualRealm(_realm);
        _creatures.add(p_creature);
    }

    /**
     *
     * @param p_name
     * @return
     */
    public boolean delCreature(String p_name) {
        for(int i=0;i<_creatures.size();i++) {
            if(_creatures.get(i).getName().equalsIgnoreCase(p_name)) {
                _creatures.get(i).setActualRealm(null);
                _creatures.remove(i);
                return true;
            }
        }
        return false;
    }
}
