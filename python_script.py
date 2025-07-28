from py4j.java_gateway import JavaGateway

# Start the gateway connection
gateway = JavaGateway()  # Connect to the Java process
campaign_manager = gateway.entry_point  # Get the CampaignManager instance

# Create a new campaign using the Java class
campaign = campaign_manager.createCampaign("Summer Campaign", "A campaign to promote summer sales.", "Active")

# Print the campaign details
campaign_manager.printCampaignDetails(campaign)

# Modify the campaign status and print the updated details
campaign.setStatus("Completed")
campaign_manager.printCampaignDetails(campaign)
