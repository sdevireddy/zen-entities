package com.zen.entities.tenant;

public enum LeadSource {
    ADVERTISEMENT,    // Paid ads (Google Ads, Facebook Ads, etc.)
    WEBSITE,         // Website form submissions
    REFERRAL,        // Referral from existing customer or partner
    SOCIAL_MEDIA,    // Social media platforms (Facebook, LinkedIn, etc.)
    OTHER,           // Any other source not listed
    EMAIL,           // Email campaign
    PHONE,           // Phone call / inbound
    TRADE_SHOW,      // Events, trade shows, conferences
    COLD_CALL,       // Outbound cold calling
    DIRECT_MAIL,     // Postal mail campaigns
    WEBINAR,         // Online webinars
    CONTENT_MARKETING, // Blog posts, whitepapers, ebooks
    SEO,             // Organic search results
    PARTNER,         // Partner referrals
    EMPLOYEE_REFERRAL, // Employee referrals
    WORD_OF_MOUTH,   // Word of mouth recommendations
    PRINT_MEDIA,     // Newspapers, magazines
    RADIO,           // Radio advertisements
    TV,              // Television advertisements
    OUTDOOR,         // Billboards, outdoor advertising
    NETWORKING,      // Professional networking events
    CUSTOMER_REFERRAL, // Existing customer referrals
    VENDOR_REFERRAL, // Vendor referrals
    CONSULTANT_REFERRAL, // Consultant referrals
    ONLINE_DIRECTORY, // Online business directories
    REVIEW_SITE,     // Review sites (Google Reviews, Yelp)
    PODCAST,         // Podcast sponsorships or appearances
    YOUTUBE,         // YouTube channel or ads
    LINKEDIN,        // LinkedIn specific campaigns
    FACEBOOK,        // Facebook specific campaigns
    TWITTER,         // Twitter specific campaigns
    INSTAGRAM,       // Instagram specific campaigns
    TIKTOK,          // TikTok campaigns
    MOBILE_APP,      // Mobile app downloads or interactions
    QR_CODE,         // QR code campaigns
    SMS,             // SMS marketing campaigns
    CHATBOT,         // Website chatbot interactions
    LIVE_CHAT,       // Live chat support interactions
    FORUM,           // Online forums and communities
    MARKETPLACE,     // Online marketplaces (Amazon, eBay)
    AFFILIATE,       // Affiliate marketing programs
    INFLUENCER,      // Influencer marketing
    RETARGETING,     // Retargeting campaigns
    REMARKETING,     // Remarketing campaigns
    ORGANIC_SOCIAL,  // Organic social media posts
    PAID_SOCIAL,     // Paid social media campaigns
    DISPLAY_ADS,     // Display advertising
    VIDEO_ADS,       // Video advertising
    NATIVE_ADS,      // Native advertising
    SPONSORSHIP,     // Event or content sponsorships
    PR,              // Public relations activities
    PRESS_RELEASE,   // Press releases
    MEDIA_COVERAGE,  // Media coverage and mentions
    CONFERENCE,      // Industry conferences
    SEMINAR,         // Educational seminars
    WORKSHOP,        // Training workshops
    DEMO,            // Product demonstrations
    TRIAL,           // Free trials or samples
    LOYALTY_PROGRAM, // Customer loyalty programs
    CROSS_SELL,      // Cross-selling to existing customers
    UPSELL,          // Upselling to existing customers
    WIN_BACK,        // Win-back campaigns for lost customers
    REACTIVATION,    // Customer reactivation campaigns
    SURVEY,          // Customer surveys and feedback
    CONTEST,         // Contests and giveaways
    PROMOTION,       // Special promotions and discounts
    SEASONAL,        // Seasonal marketing campaigns
    GEOGRAPHIC,      // Location-based marketing
    DEMOGRAPHIC,     // Demographic-targeted campaigns
    BEHAVIORAL,      // Behavioral targeting
    PSYCHOGRAPHIC,   // Psychographic targeting
    LOOKALIKE,       // Lookalike audience campaigns
    CUSTOM_AUDIENCE, // Custom audience targeting
    RETARGETING_LIST, // Retargeting list campaigns
    SEARCH_ADS,      // Search engine advertising
    SHOPPING_ADS,    // Shopping advertisements
    LOCAL_ADS,       // Local business advertisements
    MOBILE_ADS,      // Mobile-specific advertisements
    IN_APP_ADS,      // In-app advertisements
    PUSH_NOTIFICATION, // Push notifications
    EMAIL_SIGNATURE, // Email signature campaigns
    BUSINESS_CARD,   // Business card referrals
    BROCHURE,        // Marketing brochures
    CATALOG,         // Product catalogs
    FLYER,           // Marketing flyers
    POSTCARD,        // Direct mail postcards
    DOOR_TO_DOOR,    // Door-to-door sales
    KIOSK,           // Interactive kiosks
    POINT_OF_SALE,   // Point of sale materials
    PACKAGING,       // Product packaging promotions
    VEHICLE_WRAP,    // Vehicle advertising wraps
    TRANSIT_ADS,     // Public transit advertisements
    AIRPORT_ADS,     // Airport advertising
    STADIUM_ADS,     // Stadium and venue advertising
    CINEMA_ADS,      // Movie theater advertisements
    STREAMING_ADS,   // Streaming service advertisements
    GAMING_ADS,      // In-game advertisements
    VR_AR_ADS,       // Virtual/Augmented reality ads
    VOICE_ADS,       // Voice assistant advertisements
    SMART_TV_ADS,    // Smart TV advertisements
    CONNECTED_CAR,   // Connected car advertisements
    IOT_DEVICE,      // Internet of Things device interactions
    BEACON,          // Bluetooth beacon marketing
    GEOFENCING,      // Location-based geofencing
    WEATHER_TARGETING, // Weather-based targeting
    TIME_TARGETING,  // Time-based targeting
    DEVICE_TARGETING, // Device-specific targeting
    BROWSER_TARGETING, // Browser-specific targeting
    OS_TARGETING,    // Operating system targeting
    CARRIER_TARGETING, // Mobile carrier targeting
    WIFI_MARKETING,  // WiFi-based marketing
    NFC_MARKETING,   // Near Field Communication marketing
    AUGMENTED_REALITY, // AR marketing experiences
    VIRTUAL_REALITY, // VR marketing experiences
    CHATGPT,         // AI chatbot interactions
    VOICE_ASSISTANT, // Voice assistant interactions
    SMART_SPEAKER,   // Smart speaker advertisements
    WEARABLE_DEVICE, // Wearable device notifications
    HEALTH_APP,      // Health and fitness app promotions
    FINANCE_APP,     // Financial app promotions
    TRAVEL_APP,      // Travel app promotions
    FOOD_APP,        // Food delivery app promotions
    RIDE_SHARE,      // Ride-sharing app promotions
    DELIVERY_SERVICE, // Delivery service promotions
    SUBSCRIPTION_BOX, // Subscription box partnerships
    LOYALTY_CARD,    // Loyalty card programs
    GIFT_CARD,       // Gift card promotions
    CASHBACK,        // Cashback programs
    REWARDS_PROGRAM, // Rewards program partnerships
    CREDIT_CARD,     // Credit card partnerships
    BANK_PARTNERSHIP, // Banking partnerships
    INSURANCE_PARTNERSHIP, // Insurance partnerships
    TELECOM_PARTNERSHIP, // Telecom partnerships
    UTILITY_PARTNERSHIP, // Utility company partnerships
    GOVERNMENT,      // Government partnerships
    NONPROFIT,       // Nonprofit partnerships
    EDUCATIONAL,     // Educational institution partnerships
    HEALTHCARE,      // Healthcare partnerships
    RETAIL_PARTNERSHIP, // Retail partnerships
    FRANCHISE,       // Franchise partnerships
    DISTRIBUTOR,     // Distributor partnerships
    RESELLER,        // Reseller partnerships
    INTEGRATOR,      // System integrator partnerships
    CONSULTANT_PARTNERSHIP, // Consultant partnerships
    AGENCY_PARTNERSHIP, // Agency partnerships
    TECHNOLOGY_PARTNERSHIP, // Technology partnerships
    STRATEGIC_ALLIANCE, // Strategic alliances
    JOINT_VENTURE,   // Joint ventures
    ACQUISITION,     // Customer acquisition through acquisitions
    MERGER,          // Customer acquisition through mergers
    LICENSING,       // Licensing partnerships
    WHITE_LABEL,     // White label partnerships
    PRIVATE_LABEL,   // Private label partnerships
    CO_BRANDING,     // Co-branding partnerships
    CROSS_PROMOTION, // Cross-promotional partnerships
    BUNDLE_PARTNERSHIP, // Product bundling partnerships
    INTEGRATION_PARTNERSHIP, // Integration partnerships
    API_PARTNERSHIP, // API partnerships
    PLATFORM_PARTNERSHIP, // Platform partnerships
    MARKETPLACE_PARTNERSHIP, // Marketplace partnerships
    ECOSYSTEM_PARTNERSHIP, // Ecosystem partnerships
    COMMUNITY_PARTNERSHIP, // Community partnerships
    DEVELOPER_PROGRAM, // Developer program partnerships
    STARTUP_PROGRAM, // Startup program partnerships
    ACCELERATOR,     // Accelerator program partnerships
    INCUBATOR,       // Incubator program partnerships
    VENTURE_CAPITAL, // Venture capital partnerships
    ANGEL_INVESTOR,  // Angel investor partnerships
    CROWDFUNDING,    // Crowdfunding campaigns
    PEER_TO_PEER,    // Peer-to-peer referrals
    COMMUNITY_DRIVEN, // Community-driven referrals
    USER_GENERATED,  // User-generated content
    VIRAL_MARKETING, // Viral marketing campaigns
    GUERRILLA_MARKETING, // Guerrilla marketing tactics
    EXPERIENTIAL,    // Experiential marketing
    AMBIENT_MARKETING, // Ambient marketing
    STEALTH_MARKETING, // Stealth marketing
    BUZZ_MARKETING,  // Buzz marketing
    GRASSROOTS,      // Grassroots marketing
    ASTROTURFING,    // Astroturfing campaigns
    NEUROMARKETING,  // Neuromarketing techniques
    BEHAVIORAL_ECONOMICS, // Behavioral economics applications
    GAMIFICATION,    // Gamification strategies
    PERSONALIZATION, // Personalized marketing
    HYPER_TARGETING, // Hyper-targeted campaigns
    MICRO_TARGETING, // Micro-targeted campaigns
    NANO_TARGETING,  // Nano-targeted campaigns
    ONE_TO_ONE,      // One-to-one marketing
    ACCOUNT_BASED,   // Account-based marketing
    INTENT_BASED,    // Intent-based marketing
    PREDICTIVE,      // Predictive marketing
    AI_DRIVEN,       // AI-driven marketing
    MACHINE_LEARNING, // Machine learning campaigns
    DEEP_LEARNING,   // Deep learning applications
    NEURAL_NETWORK,  // Neural network marketing
    NATURAL_LANGUAGE, // Natural language processing
    COMPUTER_VISION, // Computer vision marketing
    FACIAL_RECOGNITION, // Facial recognition marketing
    EMOTION_DETECTION, // Emotion detection marketing
    SENTIMENT_ANALYSIS, // Sentiment analysis campaigns
    SOCIAL_LISTENING, // Social media listening
    TREND_ANALYSIS,  // Trend analysis marketing
    MARKET_RESEARCH, // Market research campaigns
    CUSTOMER_INSIGHT, // Customer insight campaigns
    DATA_MINING,     // Data mining applications
    BIG_DATA,        // Big data marketing
    ANALYTICS_DRIVEN, // Analytics-driven campaigns
    PERFORMANCE_MARKETING, // Performance marketing
    GROWTH_HACKING,  // Growth hacking techniques
    CONVERSION_OPTIMIZATION, // Conversion optimization
    FUNNEL_OPTIMIZATION, // Sales funnel optimization
    LIFECYCLE_MARKETING, // Customer lifecycle marketing
    RETENTION_MARKETING, // Customer retention campaigns
    CHURN_PREVENTION, // Churn prevention campaigns
    WINBACK_CAMPAIGN, // Win-back campaigns
    ADVOCACY_PROGRAM, // Customer advocacy programs
    AMBASSADOR_PROGRAM, // Brand ambassador programs
    REFERRAL_PROGRAM, // Structured referral programs
    AFFILIATE_NETWORK, // Affiliate network programs
    PERFORMANCE_NETWORK, // Performance marketing networks
    AD_NETWORK,      // Advertising networks
    DEMAND_SIDE_PLATFORM, // Demand-side platforms
    SUPPLY_SIDE_PLATFORM, // Supply-side platforms
    AD_EXCHANGE,     // Ad exchange platforms
    REAL_TIME_BIDDING, // Real-time bidding
    PROGRAMMATIC,    // Programmatic advertising
    HEADER_BIDDING,  // Header bidding
    PRIVATE_MARKETPLACE, // Private marketplace deals
    PREFERRED_DEALS, // Preferred deal arrangements
    GUARANTEED_DEALS, // Guaranteed deal arrangements
    DIRECT_DEALS,    // Direct advertising deals
    SPONSORSHIP_DEALS, // Sponsorship arrangements
    BRANDED_CONTENT, // Branded content partnerships
    NATIVE_CONTENT,  // Native content marketing
    CONTENT_SYNDICATION, // Content syndication
    GUEST_POSTING,   // Guest posting campaigns
    THOUGHT_LEADERSHIP, // Thought leadership content
    EXPERT_POSITIONING, // Expert positioning campaigns
    INDUSTRY_RECOGNITION, // Industry recognition campaigns
    AWARD_CAMPAIGNS, // Award and recognition campaigns
    CERTIFICATION,   // Certification programs
    ACCREDITATION,   // Accreditation programs
    COMPLIANCE,      // Compliance-driven marketing
    REGULATORY,      // Regulatory compliance marketing
    ETHICAL_MARKETING, // Ethical marketing practices
    SUSTAINABLE_MARKETING, // Sustainable marketing practices
    GREEN_MARKETING, // Environmental marketing
    SOCIAL_RESPONSIBILITY, // Corporate social responsibility
    CAUSE_MARKETING, // Cause-related marketing
    CHARITY_PARTNERSHIP, // Charity partnerships
    VOLUNTEER_PROGRAM, // Volunteer program marketing
    COMMUNITY_SERVICE, // Community service marketing
    LOCAL_COMMUNITY, // Local community engagement
    NEIGHBORHOOD,    // Neighborhood marketing
    HYPERLOCAL,      // Hyperlocal marketing
    REGIONAL,        // Regional marketing campaigns
    NATIONAL,        // National marketing campaigns
    INTERNATIONAL,   // International marketing campaigns
    GLOBAL,          // Global marketing campaigns
    MULTICULTURAL,   // Multicultural marketing
    MULTILINGUAL,    // Multilingual marketing
    CULTURAL_MARKETING, // Cultural marketing campaigns
    RELIGIOUS_MARKETING, // Religious community marketing
    ETHNIC_MARKETING, // Ethnic community marketing
    GENERATIONAL,    // Generational marketing
    LIFECYCLE_STAGE, // Lifecycle stage marketing
    LIFE_EVENT,      // Life event marketing
    SEASONAL_EVENT,  // Seasonal event marketing
    HOLIDAY_MARKETING, // Holiday marketing campaigns
    BACK_TO_SCHOOL,  // Back-to-school campaigns
    BLACK_FRIDAY,    // Black Friday campaigns
    CYBER_MONDAY,    // Cyber Monday campaigns
    VALENTINES_DAY,  // Valentine's Day campaigns
    MOTHERS_DAY,     // Mother's Day campaigns
    FATHERS_DAY,     // Father's Day campaigns
    GRADUATION,      // Graduation season campaigns
    WEDDING_SEASON,  // Wedding season campaigns
    TAX_SEASON,      // Tax season campaigns
    NEW_YEAR,        // New Year campaigns
    SPRING_CLEANING, // Spring cleaning campaigns
    SUMMER_VACATION, // Summer vacation campaigns
    FALL_PREPARATION, // Fall preparation campaigns
    WINTER_PREPARATION, // Winter preparation campaigns
    WEATHER_DEPENDENT, // Weather-dependent campaigns
    CRISIS_MARKETING, // Crisis response marketing
    EMERGENCY_MARKETING, // Emergency marketing
    DISASTER_RELIEF, // Disaster relief marketing
    PANDEMIC_MARKETING, // Pandemic response marketing
    ECONOMIC_DOWNTURN, // Economic downturn marketing
    RECESSION_MARKETING, // Recession marketing
    RECOVERY_MARKETING, // Economic recovery marketing
    BOOM_MARKETING,  // Economic boom marketing
    INFLATION_MARKETING, // Inflation response marketing
    DEFLATION_MARKETING, // Deflation response marketing
    CURRENCY_MARKETING, // Currency-based marketing
    COMMODITY_MARKETING, // Commodity-based marketing
    STOCK_MARKET,    // Stock market-based marketing
    CRYPTO_MARKETING, // Cryptocurrency marketing
    BLOCKCHAIN,      // Blockchain-based marketing
    NFT_MARKETING,   // NFT marketing campaigns
    METAVERSE,       // Metaverse marketing
    WEB3,            // Web3 marketing
    DECENTRALIZED,   // Decentralized marketing
    DAO_MARKETING,   // DAO marketing campaigns
    DEFI_MARKETING,  // DeFi marketing campaigns
    FINTECH,         // Fintech marketing
    INSURTECH,       // Insurtech marketing
    PROPTECH,        // Proptech marketing
    EDTECH,          // Edtech marketing
    HEALTHTECH,      // Healthtech marketing
    BIOTECH,         // Biotech marketing
    CLEANTECH,       // Cleantech marketing
    AGTECH,          // Agtech marketing
    FOODTECH,        // Foodtech marketing
    RETAILTECH,      // Retailtech marketing
    MARTECH,         // Martech marketing
    ADTECH,          // Adtech marketing
    SALESTECH,       // Salestech marketing
    HRTECH,          // HRtech marketing
    LEGALTECH,       // Legaltech marketing
    REGTECH,         // Regtech marketing
    SUPTECH,         // Suptech marketing
    GOVTECH,         // Govtech marketing
    CIVICTECH,       // Civictech marketing
    SOCIALTECH,      // Social technology marketing
    IMPACTTECH,      // Impact technology marketing
    SUSTAINTECH,     // Sustainable technology marketing
    CLIMATETECH,     // Climate technology marketing
    CARBONTECH,      // Carbon technology marketing
    RENEWABLETECH,   // Renewable technology marketing
    ENERGYTECH,      // Energy technology marketing
    MOBILITYTECH,    // Mobility technology marketing
    TRANSPORTECH,    // Transportation technology marketing
    LOGISTICSTECH,   // Logistics technology marketing
    SUPPLYTECH,      // Supply chain technology marketing
    MANUFACTURINGTECH, // Manufacturing technology marketing
    INDUSTRIALTECH,  // Industrial technology marketing
    CONSTRUCTIONTECH, // Construction technology marketing
    REALESTATETECH,  // Real estate technology marketing
    HOSPITALITYTECH, // Hospitality technology marketing
    TRAVELTECH,      // Travel technology marketing
    TOURISMTECH,     // Tourism technology marketing
    ENTERTAINMENTTECH, // Entertainment technology marketing
    MEDIATECH,       // Media technology marketing
    GAMINGTECH,      // Gaming technology marketing
    SPORTSTECH,      // Sports technology marketing
    FITNESSTECH,     // Fitness technology marketing
    WELLNESSTECH,    // Wellness technology marketing
    BEAUTYTECH,      // Beauty technology marketing
    FASHIONTECH,     // Fashion technology marketing
    LUXURYTECH,      // Luxury technology marketing
    PETTECH,         // Pet technology marketing
    SENIORTECH,      // Senior technology marketing
    KIDTECH,         // Children's technology marketing
    PARENTTECH,      // Parenting technology marketing
    FAMILYTECH,      // Family technology marketing
    RELATIONSHIPTECH, // Relationship technology marketing
    DATINGTECH,      // Dating technology marketing
    SOCIALTECH_PLATFORM, // Social technology platforms
    COMMUNITYTECH,   // Community technology marketing
    NETWORKINGTECH,  // Networking technology marketing
    COLLABORATIONTECH, // Collaboration technology marketing
    PRODUCTIVITYTECH, // Productivity technology marketing
    WORKFLOWTECH,    // Workflow technology marketing
    AUTOMATIONTECH,  // Automation technology marketing
    ROBOTICSTECH,    // Robotics technology marketing
    AITECH,          // AI technology marketing
    MLTECH,          // Machine learning technology marketing
    DATATECH,        // Data technology marketing
    ANALYTICSTECH,   // Analytics technology marketing
    BUSINESSTECH,    // Business technology marketing
    ENTERPRISETECH,  // Enterprise technology marketing
    STARTUPTECH,     // Startup technology marketing
    SCALEUPTECH,     // Scaleup technology marketing
    UNICORNTECH,     // Unicorn technology marketing
    DECACORNTECH,    // Decacorn technology marketing
    UNKNOWN          // Unknown or unspecified source
}

