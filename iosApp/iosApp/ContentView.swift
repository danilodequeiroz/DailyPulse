import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
        var viewModel: ArticlesScreen.ArticlesViewModelWrapper {
           if ProcessInfo.processInfo.environment["XCODE_RUNNING_FOR_PREVIEWS"] == "1" {
               return MockSuccessArticlesViewModelWrapper()
           } else {
               return ArticlesScreen.ArticlesViewModelWrapper()
           }
        }
        ArticlesScreen(
            viewModel: viewModel
        )
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