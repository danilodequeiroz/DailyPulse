//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Danilo de Queiroz on 30/06/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ArticlesScreen: View {
    
    @ObservedObject private(set) var viewModel: ArticlesViewModelWrapper
    
    var body: some View {
        VStack{
            AppBar()
            if viewModel.articlesState.loading{
                Loader()
            }
            if let error = viewModel.articlesState.error {
                ErrorMessage(message: error)
            }
            if (!viewModel.articlesState.articles.isEmpty) {
                ScrollView {
                    LazyVStack(spacing : 10){
                        ForEach(viewModel.articlesState.articles, id: \.self){ article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }
        }.onAppear{
            viewModel.startObserving()
        }
    }
}

#Preview {
    let mock = MockSuccessArticlesViewModelWrapper()
    return ArticlesScreen(
        viewModel: mock
    )
}

#Preview {
    let mock = MockErrorArticlesViewModelWrapper()
    return ArticlesScreen(
        viewModel: mock
    )
}

#Preview {
    let mock = MockLoadingArticlesViewModelWrapper()
    return ArticlesScreen(
        viewModel: mock
    )
}