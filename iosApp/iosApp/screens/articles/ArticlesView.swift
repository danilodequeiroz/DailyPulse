//
//  ArticlesView.swift
//  iosApp
//
//  Created by Danilo de Queiroz on 30/06/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AppBar: View{
    var body : some View {
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct ArticleItemView: View{
    var article : Article
    
    var body : some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.imageUri)) { phase in
                if phase.image != nil {
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: ContentMode.fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }
            Text(article.title)
                .fontWeight(Font.Weight.bold)
            Text(article.desc)
            Text(article.date)
                .frame(
                    maxWidth: CGFloat.infinity,
                    alignment: Alignment.trailing)
                .foregroundStyle(Color.gray)
        }
        .padding(16)
    }
}

struct Loader: View{
    var body : some View {
        ProgressView()
        Text("Loading")
    }
}

struct ErrorMessage: View{
    var message : String
    
    var body : some View {
        Text(message)
            .font(.title)
    }
}

#Preview {
    AppBar()
}

#Preview {
    ArticleItemView(article: Article(
        title: "Stock market today: Live updates - CNBC",
        desc: "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
        date: "2023-11-09",
        imageUri: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080")
    )
}

#Preview {
    ErrorMessage(message: "Something went wrong")
}

#Preview {
    Loader()
}