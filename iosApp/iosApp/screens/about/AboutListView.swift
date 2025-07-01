//
//  AboutListView.swift
//  iosApp
//
//  Created by Danilo de Queiroz on 28/06/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import shared
import SwiftUI

struct AboutListView: View {

    var body: some View {
        List {
            let platformItems = PlatformInfo.init().platformItems()
            ForEach(platformItems.indices, id: \.self) { index in
                let item = platformItems[index]
                VStack(alignment: .leading) {
                    Text(item.0)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.1)
                        .font(.footnote)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
    }
}

#Preview {
    AboutListView()
        .preferredColorScheme(.light)
}

#Preview {
    AboutListView()
        .preferredColorScheme(.dark)
}

struct AboutListView_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            AboutListView()
                .preferredColorScheme(.light)
            AboutListView()
                .preferredColorScheme(.dark)
        }
    }
}

