//
//  PlatformInfo.swift
//  iosApp
//
//  Created by Danilo de Queiroz on 28/06/25.
//  Copyright © 2025 orgName. All rights reserved.
//
import shared
import Foundation

struct PlatformInfo {
    private let platform: Platform = Platform()

    func operatingSystem() -> (String, String) {
        return ("Operating System", "\(platform.osName) \(platform.osVersion)")
    }

    func device() -> (String, String) {
        return ("Device", platform.deviceModel)
    }

    func density() -> (String, String) {
        return ("Density", "Scale @\(platform.densityRound)x")
    }

    func platformItems() -> [(String, String)] {
        return [
            operatingSystem(),
            device(),
            density()
        ]
    }
}
