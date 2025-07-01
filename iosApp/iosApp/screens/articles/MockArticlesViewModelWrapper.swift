//
//  ArticlesViewModelWrapper.swift
//  iosApp
//
//  Created by Danilo de Queiroz on 30/06/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import shared
import SwiftUI

class MockSuccessArticlesViewModelWrapper : ArticlesScreen.ArticlesViewModelWrapper {
    
    override init() {
        super.init()
        self.articlesState = ArticlesState(
            articles: [
                Article(
                    title: "Stock market today: Live updates - CNBC",
                    desc: "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
                    date: "2023-11-09",
                    imageUri: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
                ),
                Article(
                    title: "Aktienmarkt heute: Live-Updates - CNBC",
                    desc: "Die Futures stiegen im vorbörslichen Handel, als die Wall Street versuchte, wieder Tritt zu fassen.",
                    date: "2022-11-09",
                    imageUri: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
                )

            ],
            loading: false,
            error: nil
        )
    }
    override func startObserving() {}
}

class MockLoadingArticlesViewModelWrapper : ArticlesScreen.ArticlesViewModelWrapper {
    
    override init() {
        super.init()
        self.articlesState = ArticlesState(
            articles: [],
            loading: true,
            error: nil
        )
    }
    override func startObserving() {}
}

class MockErrorArticlesViewModelWrapper : ArticlesScreen.ArticlesViewModelWrapper {
    
    override init() {
        super.init()
        self.articlesState = ArticlesState(
            articles: [],
            loading: false,
            error: "Something wrong happened."
        )
    }
    override func startObserving() {}
}