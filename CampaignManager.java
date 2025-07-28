import py4j.GatewayServer;

public class CampaignManager {

    public Campaign createCampaign(String name, String description, String status) {
        return new Campaign(name, description, status);
    }

    public void printCampaignDetails(Campaign campaign) {
        System.out.println(campaign.toString());
    }

    public static void main(String[] args) {
        CampaignManager manager = new CampaignManager();
        GatewayServer gatewayServer = new GatewayServer(manager);
        gatewayServer.start();
        System.out.println("Gateway Server Started");
    }
}
