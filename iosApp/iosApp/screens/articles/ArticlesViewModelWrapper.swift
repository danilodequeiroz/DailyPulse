//
//  ArticlesViewModelWrapper.swift
//  iosApp
//
//  Created by Danilo de Queiroz on 30/06/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import shared
import SwiftUI

extension ArticlesScreen {
    
    @MainActor
    class ArticlesViewModelWrapper : ObservableObject {
        let articlesViewModel : ArticlesViewModel
        
        init(){
            articlesViewModel = ArticlesInjector().articlesViewModel
            articlesState = articlesViewModel.articlesState.value
        }
        
        init(mockState: ArticlesState) {
            self.articlesViewModel = ArticlesInjector().articlesViewModel
            self.articlesState = mockState
        }
        
        @Published var articlesState : ArticlesState
        
        func startObserving(){
            Task{
                for await newState in articlesViewModel.articlesState {
                    self.articlesState = newState
                }
            }
        }
    }
}
