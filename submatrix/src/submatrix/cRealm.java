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

/*

    submatrix::cRealm.java

 */
/**
 * Realm
 * @author david
 */
public class cRealm {

    private String _name;
    private cPlane _plane;

    /**
     * Constructor sem parâmetros
     */
    public cRealm() {
        setName("");
        setPlane(new cPlane());
    }

    /**
     * Constructor
     * @param p_name - nome do realm
     * @param p_plane - plano de jogo
     */
    public cRealm(String p_name, cPlane p_plane) {
        setName(p_name);
        setPlane(p_plane);
    }

    /**
     * Modificador do nome
     * @param p_name
     */
    public void setName(String p_name) {
        _name=p_name;
    }

    /**
     * Modificador do plano
     * @param p_plane
     */
    public void setPlane(cPlane p_plane) {
        _plane=p_plane;
    }

    /**
     * Selector
     * @return - nome do realm
     */
    public String getName() {
        return _name;
    }

    /**
     * Selector
     * @return - plano de jogo
     */
    public cPlane getPlane() {
        return _plane;
    }

    @Override public String toString() {
        return getName();
    }

}
