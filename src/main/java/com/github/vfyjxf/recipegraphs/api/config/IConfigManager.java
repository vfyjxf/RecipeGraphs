package com.github.vfyjxf.recipegraphs.api.config;

import java.util.List;

public interface IConfigManager {

    List<IConfigCategory> getCategories();

    IConfigCategory getCategories(String categoryName);

}
