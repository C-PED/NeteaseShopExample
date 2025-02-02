package com.cped.demo.netesaeshop;

import com.cped.neteaseshop.ShopAPI;
import com.cped.neteaseshop.object.ItemResponse;
import org.bukkit.entity.Player;

/**
 * ShopAPI 接口用于定义与商店操作相关的回调接口，这些操作包括发货、订单完成以及错误处理等。
 * 这个接口的实现类将负责处理与商品发货、订单管理等相关的业务逻辑。
 * 各种操作通过回调方法通知调用者处理结果。
 *
 * 具体方法说明：
 * 1. `tryShipItemFailed()`：
 *    - 在尝试发货失败时调用该方法。该方法可用于处理发货失败的逻辑（如重试机制、错误日志记录等）。
 *
 * 2. `tryShipItemCancelled()`：
 *    - 当玩家取消发货请求时调用该方法。可用于清理状态或通知玩家发货已被取消。
 *
 * 3. `finPlayerOrderFailed()`：
 *    - 在玩家订单完成失败时调用该方法。用于处理订单完成过程中发生错误时的回调。
 *
 * 4. `finPlayerOrderCancelled()`：
 *    - 在玩家订单被取消时调用该方法。用于处理订单取消时的逻辑，可能涉及清理、恢复库存等操作。
 *
 * 5. `completed(ItemResponse response)`：
 *    - 在订单完成时调用该方法。此方法用于处理订单成功完成后的相关操作。
 *
 * 6. `shipmentCompleted(ItemResponse response, Player player)`：
 *    - 在商品发货成功完成时调用该方法。它通知 API 发货完成，并可以执行相关操作）。
 *
 * 7. `jsonError(ItemResponse response, Player player)`：
 *    - 当处理 JSON 响应出错时调用该方法。可以用于记录错误信息、向玩家返回错误提示等。
 */
public class ShopAPIExample implements ShopAPI {
    @Override
    public void tryShipItemFailed() {
        DemoShop.getInstance().getLogger().warning("发货尝试失败。");
    }

    @Override
    public void tryShipItemCancelled() {
        DemoShop.getInstance().getLogger().info("发货已取消。");
    }

    @Override
    public void finPlayerOrderFailed() {
        DemoShop.getInstance().getLogger().warning("订单完成失败。");
    }

    @Override
    public void finPlayerOrderCancelled() {
        DemoShop.getInstance().getLogger().info("订单已取消。");
    }

    @Override
    public void completed(ItemResponse itemResponse) {
        DemoShop.getInstance().getLogger().info("订单完成，订单ID: " + itemResponse.getEntities().get(0).getOrderid());
    }

    @Override
    public void shipmentCompleted(ItemResponse itemResponse, Player player) {
        DemoShop.getInstance().getLogger().info("发货成功，玩家: " + player.getName() + "，订单ID: " + itemResponse.getEntities().get(0).getOrderid());
    }

    @Override
    public void jsonError(ItemResponse itemResponse, Player player) {
        DemoShop.getInstance().getLogger().severe("处理JSON时发生错误，玩家: " + player.getName() + "，订单ID: " + itemResponse.getEntities().get(0).getOrderid());
    }
}