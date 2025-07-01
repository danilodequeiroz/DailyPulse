import SwiftUI
import shared

struct ContentView: View {
    
    @State private var shouldOpenAbout = false
    
	var body: some View {
        var viewModel: ArticlesScreen.ArticlesViewModelWrapper {
           if ProcessInfo.processInfo.environment["XCODE_RUNNING_FOR_PREVIEWS"] == "1" {
               return MockSuccessArticlesViewModelWrapper()
           } else {
               return ArticlesScreen.ArticlesViewModelWrapper()
           }
        }
        NavigationStack{
            ArticlesScreen(
                viewModel: viewModel
            )
            .toolbar {
                ToolbarItem {
                    Button {
                        shouldOpenAbout = true
                    } label: {
                        Label("About", systemImage: "info.circle")
                            .labelStyle(TitleAndIconLabelStyle.titleAndIcon)
                    }
                    .popover(isPresented: $shouldOpenAbout){
                        AboutScreen()
                    }
                }
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        Group {
            ContentView()
                .preferredColorScheme(.dark)
            ContentView()
                .preferredColorScheme(ColorScheme.light)
        }
	}
}