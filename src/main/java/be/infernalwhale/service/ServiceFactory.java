package be.infernalwhale.service;

import be.infernalwhale.service.fake.FakeCategoryService;
import be.infernalwhale.service.fake.FakeConnectionManager;

public class ServiceFactory {
    public static CategoryService createCategoryService() {
        return new FakeCategoryService();
    }

    public static ConnectionManager createConnectionManager() {
        return new FakeConnectionManager();
    }
}
