package com.silvercoffee.network;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashSet;

/**
 *
 * @author Andre Chateaubriand
 */
public interface ServerListener {
    public void changedLoggedUsers(HashSet<Network.Player> loggedIn);
}
