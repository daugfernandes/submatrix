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

    submatrix::cGame.java

 */
/**
 * Jogo - classe principal agregadora de toda a informação necessária para o jogo.
 * @author david
 */
public class cGame {

    // TODO: make use of hashes instead of Vectors
    private ArrayList<cRealm> _realms;
    private ArrayList<cCreature> _creatures;

    /**
     * Constructor sem parâmetros.
     */
    public cGame() {
        _realms=new ArrayList<cRealm>(0);
        _creatures=new ArrayList<cCreature>(0);
    }

    /**
     * Selector
     * @return realms
     */
    public ArrayList<cRealm> getRealms() {
        return _realms;
    }

    /**
     * Selector
     * @return criaturas
     */
    public ArrayList<cCreature> getCreatures() {
        return _creatures;
    }

    /**
     * Adiciona um realm ao jogo.
     * @param p_realm - realm a adicionar
     * @return - indicador do sucesso da adição. Não pode adicionar um realm
     * com um nome já existente, por exempplo. Neste caso retornará 'false'.
     */
    public boolean addRealm(cRealm p_realm) {
        for(int i=0;i<_realms.size();i++)
            if(_realms.get(i).getName().equalsIgnoreCase(p_realm.getName()))
               return false;

        _realms.add(p_realm);
        return true;
    }

    /**
     * Adiciona uma criatura ao jogo.
     * @param p_creature - criatura a adicionar
     * @return - indicador do sucesso da adição. (comportamento semelhante ao de
     * addRealm).
     */
    public boolean addCreature(cCreature p_creature) {
        for(int i=0;i<_creatures.size();i++)
            if(_creatures.get(i).getName().equalsIgnoreCase(p_creature.getName()))
               return false;

        _creatures.add(p_creature);
        return true;
    }

    /**
     * Pesquisa criatura por nome.
     * @param p_name - nome da criatura a pesquisar
     * @return cCreature
     */
    public cCreature getCreatureByName(String p_name) {

        for(int i=0;i<_creatures.size();i++)
            if(_creatures.get(i).getName().equalsIgnoreCase(p_name))
                return _creatures.get(i);

        return null;
    }

    /**
     * Pesquisa realm por nome.
     * @param p_name - nome do realm a pesquisar
     * @return cRealm
     */
    public cRealm getRealmByName(String p_name) {

        for(int i=0;i<_realms.size();i++)
            if(_realms.get(i).getName().equalsIgnoreCase(p_name))
                return _realms.get(i);

        return null;
    }

}
