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

    private struct RowItem: Hashable {
        let title : String
        let subtitle : String
    }

    private let items: [RowItem] = {
      let platform : Platform = Platform()
        platform.logSystemInfo()
        var result: [RowItem] = [
            .init(
                title: "Operating System",
                subtitle: "\(platform.osName) \(platform.osVersion)"
            ),
            .init(
                title: "Device",
                subtitle: "\(platform.deviceModel)"
            ),
            .init(
                title: "Density",
                subtitle: "Scale @\(platform.densityRound)x"
            )
        ]
        return result
    }()
    
    var body: some View {
        List{
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading){
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subtitle)
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

