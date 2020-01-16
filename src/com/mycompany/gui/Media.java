/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.media.MediaManager;
import java.io.IOException;

/**
 *
 * @author kaskous
 */
public class Media {
    Media video = null;
    public void Media() {
        try {
             video = (Media) MediaManager.createMedia("src\\music\\Attack on Titan Season 3 OST - Apple Seed (LYRICS Video) feat. Laco & Mpi Bertholdt Theme.mp3", true);
        } catch (IOException ex) {
        }
                    
                    
    
    }
}
