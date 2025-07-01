//
//  AboutScreen.swift
//  iosApp
//
//  Created by Danilo de Queiroz on 28/06/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack{
            AboutListView().navigationTitle("About Device")
        }
    }
}

#Preview {
    AboutScreen()
        .preferredColorScheme(.dark)
}

#Preview {
    AboutScreen()
        .preferredColorScheme(.light)
}