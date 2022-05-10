package fr.noobtopia.plugin.look;

import fr.noobtopia.plugin.rank.Rank;
import fr.noobtopia.plugin.utils.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class LookJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String message = Messages.get("look.join").replaceAll("<<player>>", player.getName());

        event.setJoinMessage(message);

        List<Rank> ranks = Rank.getRanksOf(player);
        ranks.sort((rank1, rank2) -> rank2.getDisplay() - rank1.getDisplay());
        Rank rank = ranks.get(0);

        player.setPlayerListName(rank.getColor() + rank.getName() + "§f - " + rank.getColor() + player.getName());
    }
}