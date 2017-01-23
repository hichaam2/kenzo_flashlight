package com.umang96.flashlight;

import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

/**
 * Created by Hicham on 23/01/2017.
 */

public class TorchTileService extends TileService {



    @Override
    public void onClick() {
        super.onClick();
        updateTile();
    }


    private void updateTile() {
        Tile tile = this.getQsTile();
        boolean isActive = TorchUtils.check(this);

        Icon newIcon;
        String newLabel = getString(R.string.tile_label);
        int newState = Tile.STATE_ACTIVE;

        // Change the tile to match the service status.
        if (isActive) {

            newIcon = Icon.createWithResource(getApplicationContext(),
                    R.drawable.ic_signal_flashlight_disable);


        } else {

            newIcon =
                    Icon.createWithResource(getApplicationContext(),
                            R.drawable.ic_signal_flashlight_enable);

        }

        // Change the UI of the tile.
        tile.setLabel(newLabel);
        tile.setIcon(newIcon);
        tile.setState(newState);

        // Need to call updateTile for the tile to pick up changes.
        tile.updateTile();
    }

}
